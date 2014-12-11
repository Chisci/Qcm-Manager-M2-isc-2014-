package fr.uds.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.uds.model.AbstractAnswer;
import fr.uds.model.AnswerTaken;
import fr.uds.model.ExamTaken;
import fr.uds.model.Question;
import fr.uds.service.ExamService;
import fr.uds.service.ExamTakenService;
import fr.uds.service.UserSession;

/**
 * Session Bean implementation class ExamController
 */
/**
 * 
 * Exemple de code
 * 
 * @Autowired private DummyService dummyService;
 * @RequestMapping(value = "/create.do", method = RequestMethod.POST) public
 *                       String create(Model model, @RequestParam String
 *                       dummyInput) {
 * 
 *                       model.addAttribute("dummyString",
 *                       dummyService.dummy(dummyInput));
 * 
 *                       return SUCCESS; }
 *
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
	
	@RequestMapping(value = "/display.do", method = RequestMethod.GET)
	public String displayGET(Model model) {
		
		model.addAttribute("exams", examService.getAll());
		
		return DISPLAY_TAB;
	}

	@RequestMapping(value = "/create.do", method = RequestMethod.GET)
	public String createGET(Model model) {

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

		 examService.save(userSession.getExam());

		return REDIRECT;
	}

	@RequestMapping(value = "/take.do", method = RequestMethod.GET)
	public String displayTakeExam(HttpServletRequest request, Model model) {

		/*
		 * Il faudrait créer une autre 'session' à passer à cette jsp, qui irait
		 * chercher l'examen selectionné (dans la vue d'avant ?)
		 * 
		 * Prochaine étape : voir comment y ajouter ou pas les accès à une
		 * instance de ExamTaken pour voir quelles sont les réponses données par
		 * le gars qui passe l'examen
		 */

		model.addAttribute("session", userSession);

		return ADD_TAKEEXAM;
	}

	@RequestMapping(value = "/take.do", method = RequestMethod.POST)
	public String result(HttpServletRequest request, Model model) {
		
		ExamTaken examTaken = new ExamTaken();
		// à remplacer par LE bon exam' et pas le dernier qui traine dans la session
		examTaken.setExam(userSession.getExam());
		
		for (Question question : userSession.getQuestions()) {
			AnswerTaken answerTaken = new AnswerTaken();
			answerTaken.setRelatedQuestion(question);
			for (AbstractAnswer answer : question.getAnswers()) {
				if("on".equals(request.getParameter(""+answer.getMyID()))) { 
					answerTaken.setAnswer(answer);
				}
			}
			examTaken.getAnswers().add(answerTaken);
		}
		
		examTakenService.save(examTaken);
		
		model.addAttribute("examTaken", examTaken);
		return DISPLAY_SCORE;
	}
}