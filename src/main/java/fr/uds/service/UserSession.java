package fr.uds.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.aop.scope.ScopedObject;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import fr.uds.model.Exam;
import fr.uds.model.Question;
import fr.uds.model.User;

@Component
@Scope(value="session", proxyMode=ScopedProxyMode.TARGET_CLASS)
public class UserSession {
	
	private Exam exam;
	
	private Exam currentExam;
	
	private List<Question> questions;
	
	private User user;
	
	private String currentUser;
	
	public UserSession(){
		
		exam = new Exam();
		questions = new ArrayList<Question>();
		user = new User();
		setCurrentExam(new Exam());
	}
	
	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	
	public void addQuestion(Question question) {
		this.questions.add(question);
	}
	public int questionsSize() {
		return this.questions.size();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public String getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(String currentUser) {
		this.currentUser = currentUser;
	}

	public Exam getCurrentExam() {
		return currentExam;
	}

	public void setCurrentExam(Exam currentExam) {
		this.currentExam = currentExam;
	}

	public void reset() {
		
		exam = new Exam();
		questions = new ArrayList<Question>();
	}
	
	public void reset_test() {
		ScopedObject scopedObject = (ScopedObject)this;
		scopedObject.removeFromScope();
	}
}
