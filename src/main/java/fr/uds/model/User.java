package fr.uds.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity
public class User implements Serializable,UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3271648917218513505L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	@Version
	@Column(name = "version")
	private int version;
	
	private String username;
	
	private String password;
	
	private String name;
	
	private String role;
	
	@OneToMany
	private List<Exam> exams = new ArrayList<Exam>();
	
	@OneToMany
	private List<ExamTaken> examTakens = new ArrayList<ExamTaken>();

	public User() {
		super();
	}   
	public String getLogin() {
		return this.username;
	}

	public void setLogin(String Login) {
		this.username = Login;
	}   
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String nom) {
		this.name = nom;
	}   
	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<Exam> getExams() {
		return exams;
	}
	public void setExams(List<Exam> exams) {
		this.exams = exams;
	}
	public List<ExamTaken> getExamTakens() {
		return examTakens;
	}
	public void setExamTakens(List<ExamTaken> examTakens) {
		this.examTakens = examTakens;
	}
	public void setUsername(String username) {
		this.username = username;
	}
}
