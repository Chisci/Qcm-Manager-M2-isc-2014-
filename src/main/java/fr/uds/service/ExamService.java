package fr.uds.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import fr.uds.model.Exam;
import fr.uds.model.Question;

@Repository
public class ExamService {
	
	@PersistenceContext(name="qcm-persistence-unit")
	private EntityManager entityManager;
	
	public void insertExam(Exam exam, List<Question> questions) {
		
		exam.setQuestions(questions);
		
		System.err.println(exam);
		
		entityManager.persist(exam);
	}
}
