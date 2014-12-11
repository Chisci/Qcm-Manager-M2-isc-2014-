package fr.uds.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.uds.model.Exam;

@Service
public class ExamService {

	
	@Resource
	private ExamDAO dao;
	
	@Transactional
	public void save(Exam exam ) {
		
		dao.persist(exam);
	}
}
