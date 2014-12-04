package fr.uds.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Entity implementation class for Entity: AnswerTaken
 *
 */
@Entity

public class AnswerTaken implements Serializable {

	@Id
	@GeneratedValue
	private long id;
	
	private Question relatedQuestion;
	private AbstractAnswer answer;
	private static final long serialVersionUID = 1L;

	public AnswerTaken() {
		super();
	}   
	public Question getRelatedQuestion() {
		return this.relatedQuestion;
	}

	public void setRelatedQuestion(Question relatedQuestion) {
		this.relatedQuestion = relatedQuestion;
	}   
	public AbstractAnswer getAnswer() {
		return this.answer;
	}

	public void setAnswer(AbstractAnswer answer) {
		this.answer = answer;
	}
	public int getScore(){
		return answer.getScore();
	}
   
}
