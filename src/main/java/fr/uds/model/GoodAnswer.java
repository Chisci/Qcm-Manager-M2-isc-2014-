package fr.uds.model;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class GoodAnswer extends AbstractAnswer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2854971721526967058L;
	
	public GoodAnswer(){
		
	}
	
	public GoodAnswer(String text) {
		super(text);
	}
	
	@Override
	public int getScore() {
		return 1;
	}
}