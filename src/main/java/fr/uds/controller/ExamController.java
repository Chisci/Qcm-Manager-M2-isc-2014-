package fr.uds.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.aop.scope.ScopedObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.uds.model.AbstractAnswer;
import fr.uds.model.AnswerTaken;
import fr.uds.model.Exam;
import fr.uds.model.ExamTaken;
import fr.uds.model.Question;
import fr.uds.model.User;
import fr.uds.service.ExamService;
import fr.uds.service.ExamTakenService;
import fr.uds.service.UserService;
import fr.uds.service.UserSession;

/**
 * Session Bean implementation class ExamController
 */

@Controller
@RequestMapping("/exam")
public class ExamController {

	private static final String DISPLAY_CREATE = "createExam";

	// private static final String ADD_QUESTION = "createQuestion";

	private static final String ADD_TAKEEXAM = "takeExam";

	private static final String HOME = "welcome";

	private static final String REDIRECT = "redirect:create.do";
	
	private static final String DISPLAY_SCORE = "display_score";

	private static final String DISPLAY_TAB = "display_tab_exam";

	@Autowired
	private UserSession userSession;

	@Resource
	private ExamService examService;
	
	@Resource
	private ExamTakenService examTakenService;
	
	@Resource
	private UserService userService;
	
	@RequestMapping(value = "/display.do", method = RequestMethod.GET)
	public String displayGET(HttpServletRequest request, Model model) {

		String loggedUser = request.getUserPrincipal().getName();
		
		userSession.setCurrentUser(loggedUser);
		model.addAttribute("session", userSession);
		model.addAttribute("exams", examService.getAll());
		
		return DISPLAY_TAB;
	}

	@RequestMapping(value = "/create.do", method = RequestMethod.GET)
	public String createGET(HttpServletRequest request, Model model) {

//		User user = new User();
//		user.setUsername(request.getUserPrincipal().getName());
//		userSession.getExam().setUser(user);
		model.addAttribute("exam", userSession.getExam());
		model.addAttribute("questions", userSession.getQuestions());
		model.addAttribute("session", userSession);
		
		return DISPLAY_CREATE;
	}

	@RequestMapping(value = "/create.do", method = RequestMethod.POST)
	public String createPOST(HttpServletRequest request, Model model) {

		userSession.getExam().setTitle(request.getParameter("title"));

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		try {
			userSession.getExam().setStartDate(
					dateFormat.parse(request.getParameter("date")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}

		userSession.getExam().setQuestions(userSession.getQuestions());

		userSession.getExam().setAuthor(request.getUserPrincipal().getName());
		
		 examService.save(userSession.getExam());
		 
		 userSession.reset();
//		 userSession = new UserSession();
		 
		return REDIRECT;
	}

	@RequestMapping(value = "/take.do", method = RequestMethod.GET)
	public String displayTakeExam(HttpServletRequest request, Model model) {
		
		Exam exam = null;

		/*
		 * Il faudrait créer une autre 'session' à passer à cette jsp, qui irait
		 * chercher l'examen selectionné (dans la vue d'avant ?)
		 * 
		 * Prochaine étape : voir comment y ajouter ou pas les accès à une
		 * instance de ExamTaken pour voir quelles sont les réponses données par
		 * le gars qui passe l'examen
		 */

		long id = 0;
		String test = (request.getParameter("id"));
		
		if(test != null){	
			id = Long.parseLong(request.getParameter("id"));
		
			exam = examService.getExamById(id);
			
			// mapper l'exam avec son id
			
			model.addAttribute("exam", exam);
			userSession.setCurrentExam(exam);
	
			return ADD_TAKEEXAM;
		}
		return "";
	}

	@RequestMapping(value = "/take.do", method = RequestMethod.POST)
	public String result(HttpServletRequest request, Model model) {
		
		Exam currentExam = userSession.getCurrentExam();
		ExamTaken examTaken = new ExamTaken();
		// à remplacer par LE bon exam' et pas le dernier qui traine dans la session
		examTaken.setExam(currentExam);
		
		for (Question question : currentExam.getQuestions()) {
			AnswerTaken answerTaken = new AnswerTaken();
			answerTaken.setRelatedQuestion(question);
			for (AbstractAnswer answer : question.getAnswers()) {
				if("on".equals(request.getParameter(""+answer.getId()))) { 
					answerTaken.setAnswer(answer);
				}
			}
			examTaken.getAnswers().add(answerTaken);
		}
		
		//examTakenService.save(examTaken);
		
		model.addAttribute("examTaken", examTaken);
		return DISPLAY_SCORE;
	}
}
