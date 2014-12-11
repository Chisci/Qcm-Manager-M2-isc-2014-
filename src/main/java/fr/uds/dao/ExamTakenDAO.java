package fr.uds.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import fr.uds.model.ExamTaken;

@Repository
public class ExamTakenDAO {
	
	
	@PersistenceContext(name="qcm-persistence-unit")
	private EntityManager entityManager;
	
	public void persist(ExamTaken examTaken) {
		
		entityManager.persist(examTaken);
	}
}
