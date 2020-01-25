package com.skilldistillery.travelboard.data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skilldistillery.travelboard.entities.Event;
import com.skilldistillery.travelboard.entities.Location;
import com.skilldistillery.travelboard.entities.User;

@Service
@Transactional
public class DAOSearchIMPL implements DAOSearch {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Location searchLocation(String keyword) {
		String query = "SELECT loc FROM Location loc where loc.city = :lCity";

		List<Location> locations = em.createQuery(query, Location.class).setParameter(":lCity", keyword)
				.getResultList();

		return locations.size() > 0 ? locations.get(0) : null;
	}

	@Override
	public List<User> searchUsername(String keyword) {
		String query = "SELECT user FROM User user WHERE user.username LIKE :uName";

		List<User> users = em.createQuery(query, User.class).setParameter("uName", "%" + keyword + "%").getResultList();

		return users;
	}

	@Override
	public List<Event> searchEvent(String keyword, int locationId) {

		List<Event> events = new ArrayList<>();

		if (locationId > 0) {
			Location location = em.find(Location.class, locationId);

			String cName = location.getCity();

			String query = "SELECT event FROM Event event WHERE (event.title LIKE :eTitle OR event.hook LIKE :eHook OR event.description LIKE :eDesc) ORDER BY CASE event.location.city WHEN :cName THEN 1 ELSE 2 END, zip_code";

			events = em.createQuery(query, Event.class).setParameter("eTitle", keyword).setParameter("eHook", keyword)
					.setParameter("eDesc", keyword).setParameter(":cName", cName).getResultList();

		} else {
			String query = "SELECT event FROM Event event WHERE event.title LIKE :eTitle OR event.hook LIKE :eHook OR event.description LIKE :eDesc ORDER BY event.location.city";

			events = em.createQuery(query, Event.class).setParameter("eTitle", keyword).setParameter("eHook", keyword)
					.setParameter("eDesc", keyword).getResultList();
		}

		return events;
	}

	@Override
	public Event findEventById(int eventid) {
		Event event =em.find(Event.class, eventid);
		return event;
		
		
	}
	
}
