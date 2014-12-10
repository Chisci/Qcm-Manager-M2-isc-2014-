package fr.uds.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import fr.uds.model.Exam;

@Service
public class ExamService {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void insertExam(Exam exam) {
		
//		entityManager.persist(exam);
	}
}
