package com.skilldistillery.travelboard.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.List;
import java.util.ArrayList;
import javax.persistence.OneToMany;

@Entity
@Table(name = "location")
public class Location {

	// F I E L D S
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "city")
	private String city;

	@Column(name = "active")
	private Boolean active;

	@Column(name = "zip_code")
	private String zipCode;

	@OneToMany(mappedBy = "location")
	private List<Event> events;

	@OneToMany(mappedBy = "location")
	private List<User> users;

	// C O N S T R U C T O R S
	public Location() {
		super();
	}

	// G E T T E R S _ A N D _ S E T T E R S
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	// A D D E R S
	public void addEvent(Event event) {
		if (events == null) {
			events = new ArrayList<>();
		}
		if (!events.contains(event)) {
			events.add(event);
			if (event.getLocation() != null) {
				event.getLocation().getEvents().remove(event);
			}
		}
		event.setLocation(this);
	}

	public void removeEvent(Event event) {
		event.setLocation(null);
		if (events != null) {
			events.remove(event);
		}

	}

	public void addUser(User user) {
		if (users == null) {
			users = new ArrayList<>();
		}
		if (!users.contains(user)) {
			users.add(user);
			if (user.getLocation() != null) {
				user.getLocation().getUsers().remove(user);
			}
		}
		user.setLocation(this);
	}

	public void removeUser(User user) {
		user.setLocation(null);
		if (users != null) {
			users.remove(user);
		}

	}

	@Override
	public String toString() {
		return "Location [id=" + id + ", city=" + city + ", active=" + active + ", zipCode=" + zipCode;
	}

}
