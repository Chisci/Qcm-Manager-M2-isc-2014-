package fr.uds.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity
public abstract class AbstractAnswer {

	private static int nb_instance = 0;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	@Version
	@Column(name = "version")
	private int version;

	@Column
	private String text;
	
	private int myID;
	
	public AbstractAnswer() {
		this.myID = nb_instance++;
	}
	
	public AbstractAnswer(String text) {
		this();
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
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
	
	public int getMyID() {
		return myID;
	}

	public void setMyID(int myID) {
		this.myID = myID;
	}

	@Override
	public String toString() {
		return "AbstractAnswer [id=" + id + ", text=" + text + "]";
	}

	/**
	 * @return the score
	 */
	public abstract int getScore();

}