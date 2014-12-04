package fr.uds.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Version;

/**
 * Entity implementation class for Entity: AnswerTaken
 *
 */
@Entity
public class AnswerTaken implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2075152399978799010L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	@Version
	@Column(name = "version")
	private int version;
	
	@OneToOne
	private Question relatedQuestion;
	
	@OneToOne
	private AbstractAnswer answer;

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
