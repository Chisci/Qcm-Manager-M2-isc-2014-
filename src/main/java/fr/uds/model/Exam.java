package fr.uds.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@Entity
public class Exam implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2553814929367079453L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	@Version
	@Column(name = "version")
	private int version;

	@Column
	private String title;

	@Column
	@Temporal(TemporalType.DATE)
	private Date startDate;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Question> questions = new ArrayList<Question>();
	
	private String author;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(final int version) {
		this.version = version;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Exam)) {
			return false;
		}
		Exam other = (Exam) obj;
		if (id != null) {
			if (!id.equals(other.id)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Exam [id=" + id + ", version=" + version + ", title=" + title
				+ ", startDate=" + startDate + ", questions=" + questions + "]";
	}

	public List<Question> getQuestions() {
		return this.questions;
	}

	public void setQuestions(final List<Question> questions) {
		this.questions = questions;
	}
	public int getNbQuestion() {
		return this.questions.size();
	}
	public void addQuestion(Question question) {
		this.questions.add(question);
	}
	public String getSimpleDate() {
		
		if(startDate != null)
		{
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			return dateFormat.format(startDate);
		}
		else
		{
			return null;
		}
	}
}