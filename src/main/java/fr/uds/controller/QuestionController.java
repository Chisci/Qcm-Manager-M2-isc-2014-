package fr.uds.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.uds.model.Question;
import fr.uds.service.QuestionService;
import fr.uds.service.UserSession;

@Controller
@RequestMapping("/question")
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;
	
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
		
		questionService.insertQuestion(question);
		
		userSession.addQuestion(question);
		
		return RETURN;
	}

}
