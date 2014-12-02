package fr.uds.model;

import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Version;
import java.lang.Override;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import fr.uds.model.Question;
import java.util.Set;
import java.util.HashSet;
import javax.persistence.OneToMany;

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

	@OneToMany
	private Set<Question> questions = new HashSet<Question>();

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

	@Override
	public String toString() {
		String result = getClass().getSimpleName() + " ";
		if (title != null && !title.trim().isEmpty())
			result += "title: " + title;
		return result;
	}

	public Set<Question> getQuestions() {
		return this.questions;
	}

	public void setQuestions(final Set<Question> questions) {
		this.questions = questions;
	}
	public int getNbQuestion() {
		return this.questions.size();
	}
	public String test()
	{
		return "test";
	}
	public void addQuestion(Question question) {
		this.questions.add(question);
	}
}