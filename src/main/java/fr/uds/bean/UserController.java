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
public class UserController {

	private static final String HOME = "welcome";
	
	private static final String REGISTER = "register";


	@Autowired
	private UserSession userSession;

	@RequestMapping(value = "/register.do", method = RequestMethod.GET)
	public String register(HttpServletRequest request, Model model)
			throws ParseException {

		return REGISTER;
	}

	@RequestMapping(value = "/finish.do", method = RequestMethod.POST)
	public String finish(HttpServletRequest request, Model model)
			throws ParseException {

		return HOME;
	}
}
