package com.skilldistillery.travelboard.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;


@Entity
@Table(name="user_event")
public class UserEvent {

	// F I E L D S
	@EmbeddedId
	private UserEventId id;
	
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	@MapsId(value = "userId")
	private User user;

	@ManyToOne
	@JoinColumn(name = "event_id")
	@MapsId(value = "eventId")
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
	public UserEventId getId() {
		return id;
	}
	public void setId(UserEventId id) {
		this.id = id;
	}

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

