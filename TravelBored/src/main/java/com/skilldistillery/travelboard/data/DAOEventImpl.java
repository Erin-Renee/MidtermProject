package com.skilldistillery.travelboard.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skilldistillery.travelboard.entities.Event;
import com.skilldistillery.travelboard.entities.Event;

@Service
@Transactional
public class DAOEventImpl {
//	
//	@PersistenceContext
//	private EntityManager em;
//	
//	@Override
//	public Event create(Event event) {
//		em.persist(event);
//		em.flush();
//		
//		
//		return event;
//	}
//
//	@Override
//	public boolean delete(int eventId) {
//		
//		 Event  event = em.find( Event.class, eventId);
//		em.remove( event);
//		em.flush();
//		
//		boolean status = !em.contains( event);
//		
//		return status;
//	}
//
//	@Override
//	public Event updateEvent(Event event, int eventId) {
//		Event eventToBeUpdated = em.find(Event.class, eventId);
//		
//		eventToBeUpdated.setTitle(event.getTitle());
//		eventToBeUpdated.setHook(event.getHook());
//		eventToBeUpdated.setDescription(event.getDescription());
//		eventToBeUpdated.setEventTime(event.getEventTime());
//		eventToBeUpdated.setEventDate(event.getEventDate());
//		eventToBeUpdated.setLocation(event.getLocation());
//		eventToBeUpdated.setImgUrl(event.getImgUrl());
//		eventToBeUpdated.setEventUrl(event.getEventUrl());
//		eventToBeUpdated.setEventComments(event.getEventComments());
//		eventToBeUpdated.setActive(event.getActive());
//		
//		em.flush();
//		
//		return eventToBeUpdated;
//	}
//
//	@Override
//	public List<Event> read(String name) {
//		String query = "SELECT user FROM User user WHERE user.FirstName = :fName OR user.LastName = :lName OR user.Username = :uName";
//		
//		List<Event> users = em.createQuery(query, Event.class).setParameter("fName", name).setParameter("lName", name).setParameter("uName", name).getResultList();
//		
//		return users;
//	}
//	@Override
//	public Event login(String userName, String password) {
//		String query = "SELECT user FROM User user WHERE user.Username = :uName AND user.Password = :pWord";
//		
//		List<Event> users = em.createQuery(query, Event.class).setParameter("uName", userName).setParameter("pWord", password).getResultList();
//				
//		
//		return users.size() > 0 ? users.get(0) : null; 
//	}

}
