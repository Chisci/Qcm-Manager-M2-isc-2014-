package fr.uds.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.uds.model.AbstractAnswer;
import fr.uds.model.BadAnswer;
import fr.uds.model.GoodAnswer;
import fr.uds.model.Question;
import fr.uds.service.UserSession;

@Controller
@RequestMapping("/question")
public class QuestionController {
	
	@Autowired
	private UserSession userSession;

	private static final String SUCCESS = "createQuestion";
	
	private static final String RETURN = "redirect:/exam/create.do";

	@RequestMapping(value = "/create.do", method=RequestMethod.GET)
	public String display(HttpServletRequest request, Model model) {
		
		return SUCCESS;
	}
	
	@RequestMapping(value = "/create.do", method = RequestMethod.POST)
	public String create(HttpServletRequest request, Model model, @RequestParam String submitQuestion) {
		
		Question question = new Question();

		String text = request.getParameter("question");
		question.setText(text);
		
		List<AbstractAnswer> answers = new ArrayList<AbstractAnswer>();
		
		if(request.getParameter("answer1check") == null) {
			answers.add(new BadAnswer(request.getParameter("answer1")));
		}
		else {
			answers.add(new GoodAnswer(request.getParameter("answer1")));
		}
		
		if(request.getParameter("answer2check") == null) {
			answers.add(new BadAnswer(request.getParameter("answer2")));
		}
		else {
			answers.add(new GoodAnswer(request.getParameter("answer2")));
		}
		
		if(request.getParameter("answer3check") == null) {
			answers.add(new BadAnswer(request.getParameter("answer3")));
		}
		else {
			answers.add(new GoodAnswer(request.getParameter("answer3")));
		}
		
		if(request.getParameter("answer4check") == null) {
			answers.add(new BadAnswer(request.getParameter("answer4")));
		}
		else {
			answers.add(new GoodAnswer(request.getParameter("answer4")));
		}
		
//		System.err.println("1 : "+request.getParameter("answer1"));
//		System.err.println("1C : "+request.getParameter("answer1check"));
//		System.err.println("2 : "+request.getParameter("answer2"));
//		System.err.println("2C : "+request.getParameter("answer2check"));
		
		question.setAnswers(answers);
		
		userSession.addQuestion(question);
		
		return RETURN;
	}

}
