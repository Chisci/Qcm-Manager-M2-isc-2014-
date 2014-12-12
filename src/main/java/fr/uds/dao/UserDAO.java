package fr.uds.dao;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import fr.uds.model.User;

@Repository
public class UserDAO implements UserDetailsService {
	
	
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
	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
        return entityManager.createQuery("from User where username = :username", User.class)
                .setParameter("username", username)
                .getSingleResult();
	}
}
