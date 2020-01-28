package com.skilldistillery.travelboard.data;

import com.skilldistillery.travelboard.entities.Event;
import com.skilldistillery.travelboard.entities.User;
import com.skilldistillery.travelboard.entities.UserEvent;

public interface DAOEvent {

	public Event create(Event event);

	public boolean delete(int eventId);

	public Event update(Event event, int eventId);

	public UserEvent findUserEvent(int eventId, int userId);

	public UserEvent createUserEvent(Event event, User user);

	public boolean deleteUserEvent(Event event, User user);
	
	public UserEvent setUserEvent(UserEvent userEvent);

}
