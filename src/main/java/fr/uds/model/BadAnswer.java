package fr.uds.model;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class BadAnswer extends AbstractAnswer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3008759709720597022L;

	public BadAnswer() {
		
	}
	
	public BadAnswer(String text) {
		super(text);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int getScore() {
		return 0;
	}
}