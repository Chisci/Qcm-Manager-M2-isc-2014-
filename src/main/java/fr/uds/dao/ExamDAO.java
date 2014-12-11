package fr.uds.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import fr.uds.model.Exam;

@Repository
public class ExamDAO {
	
	
	@PersistenceContext(name="qcm-persistence-unit")
	private EntityManager entityManager;
	
	public void persist(Exam exam) {
		
		entityManager.persist(exam);
	}
	
	public List<Exam> getAllExam() {
		
		return entityManager.createQuery("SELECT e FROM Exam e").getResultList();
	}
}
