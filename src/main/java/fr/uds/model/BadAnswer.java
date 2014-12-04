package fr.uds.model;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class BadAnswer extends AbstractAnswer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3008759709720597022L;

	@Override
	public int getScore() {
		return 0;
	}
}