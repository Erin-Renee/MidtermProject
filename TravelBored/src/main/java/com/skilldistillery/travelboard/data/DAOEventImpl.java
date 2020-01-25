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
		
		em.flush();
		
		return oldEvent;
	}

}
