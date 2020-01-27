package com.skilldistillery.travelboard.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skilldistillery.travelboard.entities.User;

@Service
@Transactional
public class DAOUserIMPL implements DAOUser {
	
	@PersistenceContext
	private EntityManager em;
	
	

	@Override
	public User create(User user) {
		System.out.println(em);
		em.persist(user);
		em.flush();
		
		
		return user;
	}

	@Override
	public boolean delete(int userId) {
		User user = em.find(User.class, userId);
		em.remove(user);
		em.flush();
		
		if (user == null) {
			return true;
		} 
		
		
		return false;
	}

	@Override
	public User updateBasicUserInfo(User user, int userId) {
		User oldUser = em.find(User.class, userId);
		
		oldUser.setFirstName(user.getFirstName());
		oldUser.setLastName(user.getLastName());
		oldUser.setUsername(user.getUsername());
		oldUser.setPassword(user.getPassword());
		oldUser.setEmail(user.getEmail());
		oldUser.setLocation(user.getLocation());
		oldUser.setUserImgUrl(user.getUserImgUrl());
		oldUser.setUserDetails(user.getUserDetails());
		oldUser.setUserEvents(user.getUserEvents());
		oldUser.setEventComments(user.getEventComments());
		oldUser.setGroups(user.getGroups());
		oldUser.setGroupComments(user.getGroupComments());
		oldUser.setActive(user.getActive());
		oldUser.setRole(user.getRole());
		
		em.flush();
		
		
		return oldUser;
	}

	
	@Override
	public User login(String userName, String password) {
		String query = "SELECT user FROM User user WHERE user.email = :eName AND user.password = :pWord";
		
		List<User> users = em.createQuery(query, User.class).setParameter("eName", userName).setParameter("pWord", password).getResultList();
				
		
		return users.size() > 0 ? users.get(0) : null; 
	}
	
	@Override
	public User findUserById(int userId) {
		User user = em.find(User.class, userId);
		return user;
	}
	

}
