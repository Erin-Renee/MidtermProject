package com.skilldistillery.travelboard.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.JoinColumn;
import java.util.List;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import javax.persistence.OneToMany;


@Entity
@Table(name="event")
public class Event {

	// F I E L D S
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;


	@Column(name = "title")
	private String title;


	@Column(name = "hook")
	private String hook;


	@Column(name = "description")
	private String description;


	@Column(name = "event_time")
	private String eventTime;


	@Column(name = "event_date")
	private String eventDate;


	@Column(name = "img_url")
	private String imgUrl;


	@Column(name = "event_url")
	private String eventUrl;


	@Column(name = "active")
	private Boolean active;


	@ManyToOne
	@JoinColumn(name = "location_id")
	private Location location;


	@Column(name = "create_date")
	private String createDate;


	@OneToMany(mappedBy="event")
	private List<UserEvent> userEvents;


	@OneToMany(mappedBy="event")
	private List<EventDetails> eventDetailss;


	@OneToMany(mappedBy="event")
	private List<EventImg> eventImgs;


	@OneToMany(mappedBy="event")
	private List<EventComment> eventComments;



	
	// C O N S T R U C T O R S
	public Event() {
		super();
	}



	// G E T T E R S _ A N D _ S E T T E R S
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getHook() {
		return hook;
	}
	public void setHook(String hook) {
		this.hook = hook;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public String getEventTime() {
		return eventTime;
	}
	public void setEventTime(String eventTime) {
		this.eventTime = eventTime;
	}

	public String getEventDate() {
		return eventDate;
	}
	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}

	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getEventUrl() {
		return eventUrl;
	}
	public void setEventUrl(String eventUrl) {
		this.eventUrl = eventUrl;
	}

	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}

	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}

	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public List<UserEvent> getUserEvents() {
		return userEvents;
	}
	public void setUserEvents(List<UserEvent> userEvents) {
		this.userEvents = userEvents;
	}

	public List<EventDetails> getEventDetailss() {
		return eventDetailss;
	}
	public void setEventDetailss(List<EventDetails> eventDetailss) {
		this.eventDetailss = eventDetailss;
	}

	public List<EventImg> getEventImgs() {
		return eventImgs;
	}
	public void setEventImgs(List<EventImg> eventImgs) {
		this.eventImgs = eventImgs;
	}

	public List<EventComment> getEventComments() {
		return eventComments;
	}
	public void setEventComments(List<EventComment> eventComments) {
		this.eventComments = eventComments;
	}



	// A D D E R S
	public void addUserEvent (UserEvent userEvent) {
		if (userEvents == null) {
			userEvents = new ArrayList<>();
		}
		if (!userEvents.contains(userEvent)) {
			userEvents.add(userEvent);
			userEvent.setEvent(this);
		}
	}
	
	public void addEventDetails (EventDetails eventDetails) {
		if (eventDetailss == null) {
			eventDetailss = new ArrayList<>();
		}
		if (!eventDetailss.contains(eventDetails)) {
			eventDetailss.add(eventDetails);
			eventDetails.setEvent(this);
		}
	}
	
	public void addEventImg (EventImg eventImg) {
		if (eventImgs == null) {
			eventImgs = new ArrayList<>();
		}
		if (!eventImgs.contains(eventImg)) {
			eventImgs.add(eventImg);
			eventImg.setEvent(this);
		}
	}
	
	public void addEventComment (EventComment eventComment) {
		if (eventComments == null) {
			eventComments = new ArrayList<>();
		}
		if (!eventComments.contains(eventComment)) {
			eventComments.add(eventComment);
			eventComment.setEvent(this);
		}
	}
	

	
}	

