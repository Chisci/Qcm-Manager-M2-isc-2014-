package fr.uds.bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
@RequestMapping("/exam")
public class ExamBean {

	private static final String DISPLAY = "createExam";

	// private static final String ADD_QUESTION = "createQuestion";

	private static final String ADD_TAKEEXAM = "takeExam";

	private static final String HOME = "welcome";
	
	private static final String REGISTER = "register";

	private static final String REDIRECT = "redirect:create.do";

	@Autowired
	private UserSession userSession;

	@RequestMapping(value = "/create.do", method = RequestMethod.GET)
	public String display(HttpServletRequest request, Model model) {

		model.addAttribute("exam", userSession.getExam());

		return DISPLAY;
	}

	@RequestMapping(value = "/take.do", method = RequestMethod.GET)
	public String displayTakeExam(HttpServletRequest request, Model model) {
		
		return ADD_TAKEEXAM;
	}

	@RequestMapping(value = "/create.do", method = RequestMethod.POST)
	public String create(HttpServletRequest request, Model model) {
		userSession.getExam().setTitle(request.getParameter("title"));
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		try {
			userSession.getExam().setStartDate(
					dateFormat.parse(request.getParameter("date")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}

		return REDIRECT;
	}

	@RequestMapping(value = "/finish.do", method = RequestMethod.POST)
	public String finish(HttpServletRequest request, Model model)
			throws ParseException {

		return HOME;
	}
}
