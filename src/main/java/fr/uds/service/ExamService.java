package fr.uds.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.uds.dao.ExamDAO;
import fr.uds.model.Exam;

@Service
public class ExamService {

	
	@Resource
	private ExamDAO dao;
	
	@Transactional
	public void save(Exam exam ) {
		
		dao.persist(exam);
	}
	
	@Transactional
	public List<Exam> getAll() {
		return dao.getAllExam();
	}
	
	@Transactional
	public Exam getExamById(long id){
		return dao.getExamById(id);
	}
}
