package fr.uds.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import fr.uds.model.User;

@Repository
public class UserDAO {
	
	
	@PersistenceContext(name="qcm-persistence-unit")
	private EntityManager entityManager;
	
	public void persist(User user) {
		
		entityManager.persist(user);
	}
	
	public User getUserByUsername(String username) {
		
		return entityManager.find(User.class, username);
	}
	
	public List<User> getAllUser() {
		
		return entityManager.createQuery("SELECT u FROM User u").getResultList();
	}
}
