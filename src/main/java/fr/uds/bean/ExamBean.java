package fr.uds.bean;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.uds.model.Exam;

/**
 * Session Bean implementation class ExamBean
 */

@Controller
public class ExamBean {

	@PersistenceContext
	private EntityManager em;
	
    private static final String SUCCESS = "createExam.jsp";
    
    @RequestMapping(value = "/createExam", method = RequestMethod.GET)
    public String create(Model model) {

    	Exam newExam = new Exam();
    	
    	
        return SUCCESS;
    }
}
