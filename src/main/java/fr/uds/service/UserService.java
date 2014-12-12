package fr.uds.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.uds.dao.UserDAO;
import fr.uds.model.User;

@Service
public class UserService {

	
	@Resource
	private UserDAO dao;
	
	@Transactional
	public void save(User user) {
		
		dao.persist(user);
	}
	
	@Transactional
	public User getByUsername(String username) {
		
		return  dao.getUserByUsername(username);
	}
	
	@Transactional
	public List<User> getAll() {
		return dao.getAllUser();
	}
}
