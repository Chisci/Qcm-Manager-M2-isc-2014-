package fr.uds.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Version;

/**
 * Entity implementation class for Entity: ExamTaken
 *
 */
@Entity

public class ExamTaken implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 66229607032537057L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	@Version
	@Column(name = "version")
	private int version;
	
	@OneToOne
	private Exam exam;
	
	@OneToMany
	private List<AnswerTaken> answers = new ArrayList<AnswerTaken>();
	
	@ManyToOne
	private User user;

	public ExamTaken() {
		super();
	}   
	public Exam getExam() {
		return this.exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}   
	public List<AnswerTaken> getAnswers() {
		return this.answers;
	}

	public void setAnswers(List<AnswerTaken> answers) {
		this.answers = answers;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
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
