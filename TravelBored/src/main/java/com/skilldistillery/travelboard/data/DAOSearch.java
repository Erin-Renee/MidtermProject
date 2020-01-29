package com.skilldistillery.travelboard.data;

import java.util.List;

import com.skilldistillery.travelboard.entities.Event;
import com.skilldistillery.travelboard.entities.Group;
import com.skilldistillery.travelboard.entities.Location;
import com.skilldistillery.travelboard.entities.User;

public interface DAOSearch {
	
	public Location searchLocation(String keyword);
	public Location getLocation(int locationId);
	
	public List<Location> findAllLocations();

	public List<User> searchUsername(String keyword);
	
	public List<Event> searchEvent(String keyword, int locationId);
	
	public List<Group> searchGroup(String keyword);
	
	public Event findEventById(int eventid);
	
	
}
