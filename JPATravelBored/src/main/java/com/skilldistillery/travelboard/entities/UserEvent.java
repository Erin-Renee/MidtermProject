package com.skilldistillery.travelboard.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
@Table(name="user_event")
public class UserEvent {

	// F I E L D S
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ManyToOne
	@JoinColumn(name = "event_id")
	private Event event;


	@Column(name = "creator")
	private Boolean creator;


	@Column(name = "active")
	private Boolean active;


	@Column(name = "create_date")
	private String createDate;



	
	// C O N S T R U C T O R S
	public UserEvent() {
		super();
	}



	// G E T T E R S _ A N D _ S E T T E R S
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}

	public Boolean getCreator() {
		return creator;
	}
	public void setCreator(Boolean creator) {
		this.creator = creator;
	}

	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}



	// A D D E R S

	
}	

