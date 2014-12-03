package fr.uds.bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.uds.model.Exam;

/**
 * Session Bean implementation class ExamBean
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
public class ExamBean {

	private static final String DISPLAY = "WEB-INF/pages/createExam.jsp";

	private static final String ADD_QUESTION = "WEB-INF/pages/createQuestion.jsp";
	
	private static final String ADD_TAKEEXAM = "WEB-INF/pages/takeExam.jsp";
	
	private static final String HOME = "WEB-INF/pages/welcome.jsp";

	@RequestMapping(value = "/createExam.do", method = RequestMethod.GET)
	public String display(HttpServletRequest request, Model model) {

		
		Exam  exam  = (Exam) request.getSession().getAttribute("exam");
		if(exam == null)
		{
			exam = new Exam();
		}		
		request.getSession().setAttribute("exam", exam);

		return DISPLAY;
	}
	
	@RequestMapping(value = "/takeExam.do", method = RequestMethod.GET)
	public String displayTakeExam(HttpServletRequest request, Model model) {

		return ADD_TAKEEXAM;
	}

	@RequestMapping(value = "/examFinish.do", method = RequestMethod.POST)
	public String finish(HttpServletRequest request, Model model) throws ParseException {
		
		return HOME;
	}	
	
	
	@RequestMapping(value = "/createExam.do", method = RequestMethod.POST)
	public String create(HttpServletRequest request, Model model) throws ParseException {
		
		String title = (String) request.getParameter("title");
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); 
		Date date = dateFormat.parse(request.getParameter("date"));
		
		Exam exam = (Exam) request.getSession().getAttribute("exam");

		exam.setTitle(title);
		exam.setStartDate(date);
		request.setAttribute("exam", exam);
		
		return ADD_QUESTION;
	}	
}
