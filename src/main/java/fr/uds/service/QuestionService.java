package fr.uds.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import fr.uds.model.Question;

@Service
public class QuestionService {

	@PersistenceContext
	private EntityManager entityManager;
	
	public void insertQuestion(Question question) {
		
		entityManager.persist(question);
	}
}
