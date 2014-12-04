package fr.uds.model;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Entity implementation class for Entity: ExamTaken
 *
 */
@Entity

public class ExamTaken implements Serializable {

	@Id
	@GeneratedValue
	private long id;
	
	private Exam exam;
	private ArrayList<AnswerTaken> answers;
	private static final long serialVersionUID = 1L;

	public ExamTaken() {
		super();
	}   
	public Exam getExam() {
		return this.exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}   
	public ArrayList<AnswerTaken> getAnswers() {
		return this.answers;
	}

	public void setAnswers(ArrayList<AnswerTaken> answers) {
		this.answers = answers;
	}
	public int getScore(){
		int score = 0;
		if(answers==null)
			return score;
		for(AnswerTaken answerTaken : this.answers){
			score+=answerTaken.getScore();
		}
		return score;
	}
   
}
