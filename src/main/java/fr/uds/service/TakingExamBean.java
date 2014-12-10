package fr.uds.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import fr.uds.model.Exam;

@Service
public class TakingExamBean {

	@PersistenceContext
	EntityManager entityManager;
	
	public Exam getExam(long id){
		return entityManager.find(Exam.class, id);
	}
}
