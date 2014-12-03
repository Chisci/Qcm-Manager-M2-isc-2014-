package fr.uds.model;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity
public class User implements Serializable {

	@Id
	private int id;
	private String Login;
	private String Password;
	private String Nom;
	private String Role;
	private static final long serialVersionUID = 1L;

	public User() {
		super();
	}   
	public String getLogin() {
		return this.Login;
	}

	public void setLogin(String Login) {
		this.Login = Login;
	}   
	public String getPassword() {
		return this.Password;
	}

	public void setPassword(String Password) {
		this.Password = Password;
	}   
	public String getNom() {
		return this.Nom;
	}

	public void setNom(String Nom) {
		this.Nom = Nom;
	}   
	public String getRole() {
		return this.Role;
	}

	public void setRole(String Role) {
		this.Role = Role;
	}
   
}
