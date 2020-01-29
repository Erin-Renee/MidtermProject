package com.skilldistillery.travelboard.data;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skilldistillery.travelboard.entities.Event;
import com.skilldistillery.travelboard.entities.EventComment;
import com.skilldistillery.travelboard.entities.User;
import com.skilldistillery.travelboard.entities.UserEvent;
import com.skilldistillery.travelboard.entities.UserEventId;

@Service
@Transactional
public class DAOEventImpl implements DAOEvent {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Event create(Event event) {
		em.persist(event);
		em.flush();

		return event;
	}

	@Override
	public boolean delete(int eventId) {

		Event event = em.find(Event.class, eventId);

		em.remove(event);
		em.flush();

		if (event == null) {
			return true;
		}

		return false;
	}

	public Event update(Event event, int eventId) {
		System.out.println(event.getLocation().getId());
		Event oldEvent = em.find(Event.class, eventId);

		oldEvent.setTitle(event.getTitle());
		oldEvent.setHook(event.getHook());
		oldEvent.setDescription(event.getDescription());
		oldEvent.setEventTime(event.getEventTime());
		oldEvent.setEventDate(event.getEventDate());
		oldEvent.setImgUrl(event.getImgUrl());
		oldEvent.setEventUrl(event.getEventUrl());
		oldEvent.setActive(event.getActive());
		oldEvent.setLocation(event.getLocation());
		oldEvent.setEventDetails(event.getEventDetails());
		oldEvent.setUserEvents(event.getUserEvents());
		oldEvent.setEventImgs(event.getEventImgs());
		oldEvent.setEventComments(event.getEventComments());
		System.out.println(event.getLocation().getId());

		em.flush();

		return oldEvent;
	}

	public UserEvent findUserEvent(int eventId, int userId) {
		UserEventId usereventid = new UserEventId(userId, eventId);
		UserEvent userevent = em.find(UserEvent.class, usereventid);
		return userevent;
	}

	@Override
	public UserEvent createUserEvent(Event event, User user) {
		UserEventId usereventid = new UserEventId(user.getId(), event.getId());
		UserEvent userevent = new UserEvent();
		userevent.setId(usereventid);
		userevent.setUser(user);
		userevent.setEvent(event);
		em.persist(userevent);
		em.flush();
		return userevent;
	}
	@Override
	public UserEvent setUserEvent(UserEvent userEvent) {
		em.persist(userEvent);
		em.flush();
		return userEvent;
	}

	@Override
	public boolean deleteUserEvent(Event event, User user) {
		UserEventId usereventid = new UserEventId(user.getId(), event.getId());
		UserEvent userevent = em.find(UserEvent.class, usereventid);
		em.remove(userevent);
		em.flush();
		boolean result = true;
		if (em.find(UserEvent.class, usereventid) == null) {
			result = true;
		} else {
			result = false;
		}
		return result;
	}
	
	@Override
	public EventComment submitComment(EventComment eComment) {
		em.persist(eComment);
		em.flush();
		
		return eComment;
		
	}
	@Override
	public boolean deleteComment(int eId) {
		EventComment eComment = em.find(EventComment.class, eId);

		em.remove(eComment);
		em.flush();

		if (eComment == null) {
			return true;
		}

		return false;
		
		
	}
	

}
