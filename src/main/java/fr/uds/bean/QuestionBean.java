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
public class QuestionBean {
	
	@Autowired
	private QuestionService questionService;

	private static final String SUCCESS = "WEB-INF/pages/createQuestion.jsp";
	
	private static final String RETURN = "WEB-INF/pages/createExam.jsp";

	@RequestMapping(value = "/createQuestion.do", method=RequestMethod.GET)
	public String display(HttpServletRequest request, Model model) {
		
//		Question question = new Question();
//		request.getSession().setAttribute("question", question);
		return SUCCESS;
	}
	
	@RequestMapping(value = "/createQuestion.do", method = RequestMethod.POST)
	public String create(HttpServletRequest request, Model model, @RequestParam String submitQuestion) {
		
//		Question question = (Question) request.getSession().getAttribute("question");
//		String title = request.getParameter("question");
//		question.setText(title);
		
		return RETURN;
	}

}
