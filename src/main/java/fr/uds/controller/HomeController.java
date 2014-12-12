package fr.uds.controller;

import java.text.ParseException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.uds.model.User;
import fr.uds.service.UserService;
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
public class HomeController {

	private static final String HOME = "home";
	
	@Autowired
	private UserSession userSession;
	
	@Resource
	private UserService userService;

	@RequestMapping(value = "/home.do", method = RequestMethod.GET)
	public String home(HttpServletRequest request, Model model)
			throws ParseException {
		User newUser;
		newUser = userService.createUser(request.getUserPrincipal().getName());
		userSession.setUser(newUser);
		model.addAttribute("session", userSession);
		
		System.err.println(userService.getAll());
		return HOME;
	}

}