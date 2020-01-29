package com.skilldistillery.travelboard.data;

import java.util.List;

import com.skilldistillery.travelboard.entities.Event;
import com.skilldistillery.travelboard.entities.EventComment;
import com.skilldistillery.travelboard.entities.Group;
import com.skilldistillery.travelboard.entities.GroupComment;
import com.skilldistillery.travelboard.entities.User;

public interface DAOAdmin {
	
	public User deactivateUser(int uId);
	public Group deactivateGroup(int gId);
	public Event deactivateEvent(int eId);
	public boolean deleteEventComment(int eventId);
	public boolean deleteGroupComment(int groupId);
	public List<Event> getDeactivatedEvents();
	public List<Group> getDeactivatedGroups();
	public List<User> getDeactivatedUsers();
	public List<User> getActiveUsers();
	public List<Group> getActiveGroups();
	public List<Event> getActiveEvents();
	

}
