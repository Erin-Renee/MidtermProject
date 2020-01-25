package com.skilldistillery.travelboard.data;

import com.skilldistillery.travelboard.entities.Event;

public interface DAOEvent {

	public Event create(Event event);
	public boolean delete(int eventId);
	public Event update(Event event, int eventId);
	
}
