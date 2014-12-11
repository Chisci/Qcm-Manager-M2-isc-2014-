package fr.uds.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.uds.dao.ExamTakenDAO;
import fr.uds.model.ExamTaken;

@Service
public class ExamTakenService {

	
	@Resource
	private ExamTakenDAO dao;
	
	@Transactional
	public void save(ExamTaken examTaken ) {
		
		dao.persist(examTaken);
	}
}
