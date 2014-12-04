package fr.uds.bean;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.uds.model.Question;
import fr.uds.service.QuestionService;

@Controller
@RequestMapping("/question")
public class QuestionBean {
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private UserSession userSession;

	private static final String SUCCESS = "createQuestion";
	
	private static final String RETURN = "createExam";

	@RequestMapping(value = "/create.do", method=RequestMethod.GET)
	public String display(HttpServletRequest request, Model model) {
		
		return SUCCESS;
	}
	
	@RequestMapping(value = "/create.do", method = RequestMethod.POST)
	public String create(HttpServletRequest request, Model model, @RequestParam String submitQuestion) {
		
		Question question = new Question();

		String title = request.getParameter("question");
		question.setText(title);
		
		questionService.insertQuestion(question);
		
		userSession.addQuestion(question);
		
		return RETURN;
	}

}
