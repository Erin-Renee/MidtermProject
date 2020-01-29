package com.skilldistillery.travelboard.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skilldistillery.travelboard.entities.Event;
import com.skilldistillery.travelboard.entities.EventComment;
import com.skilldistillery.travelboard.entities.Group;
import com.skilldistillery.travelboard.entities.GroupComment;
import com.skilldistillery.travelboard.entities.Location;
import com.skilldistillery.travelboard.entities.User;
import com.skilldistillery.travelboard.entities.UserEvent;

@Service
@Transactional
public class DAOAdminIMPL implements DAOAdmin {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public User deactivateUser(int uId) {
		User user = em.find(User.class, uId);
		user.setActive(false);
		
		em.flush();
		
		return user;
	}

	@Override
	public Group deactivateGroup(int gId) {
		Group group = em.find(Group.class, gId);
		group.setActive(false);
		
		em.flush();
		
		return group;
	}

	@Override
	public Event deactivateEvent(int eId) {
		Event event = em.find(Event.class, eId);
		event.setActive(false);
		
		em.flush();
		
		return event;
	}

	@Override
	public boolean deleteEventComment(int eventId) {
		EventComment eComment = em.find(EventComment.class, eventId);
		em.remove(eComment);
		
		em.flush();
		
		boolean result = true;
		if (em.find(EventComment.class, eventId) == null) {
			result = true;
		} else {
			result = false;
		}
		
		return result;
	}

	@Override
	public boolean deleteGroupComment(int groupId) {
		GroupComment gComment = em.find(GroupComment.class, groupId);
		em.remove(gComment);
		
		em.flush();
		
		boolean result = true;
		if (em.find(GroupComment.class, groupId) == null) {
			result = true;
		} else {
			result = false;
		}
		
		return result;
	}
	@Override
	public List<User> getActiveUsers() {
		String query = "SELECT user FROM User user WHERE user.active = 1";

		List<User> users = em.createQuery(query, User.class)
				.getResultList();

		return users;
	}
	@Override
	public List<User> getDeactivatedUsers() {
		String query = "SELECT user FROM User user WHERE user.active = 0";
		
		List<User> users = em.createQuery(query, User.class)
				.getResultList();
		
		return users;
	}
	@Override
	public List<Group> getActiveGroups() {
		String query = "SELECT group FROM Group group WHERE group.active = 1";

		List<Group> groups = em.createQuery(query, Group.class)
				.getResultList();

		return groups;
	}
	@Override
	public List<Group> getDeactivatedGroups() {
		String query = "SELECT group FROM Group group WHERE group.active = 0";
		
		List<Group> groups = em.createQuery(query, Group.class)
				.getResultList();
		
		return groups;
	}
	@Override
	public List<Event> getActiveEvents() {
		String query = "SELECT event FROM Event event WHERE event.active = 1";

		List<Event> events = em.createQuery(query, Event.class)
				.getResultList();

		return events;
	}
	@Override
	public List<Event> getDeactivatedEvents() {
		String query = "SELECT event FROM Event event WHERE event.active = 0";
		
		List<Event> events = em.createQuery(query, Event.class)
				.getResultList();
		
		return events;
	}

}
