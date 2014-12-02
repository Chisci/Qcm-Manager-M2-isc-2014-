package fr.uds.bean;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Controller;

@Controller
public class QuestionBean {

	@PersistenceContext
	private EntityManager em;
	
    private static final String SUCCESS = "createQuestion.jsp";


}
