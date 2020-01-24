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
@Table(name="event_img")
public class EventImg {

	// F I E L D S
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;


	@Column(name = "event_img_url")
	private String eventImgUrl;


	@Column(name = "event_img_name")
	private String eventImgName;


	@ManyToOne
	@JoinColumn(name = "event_id")
	private Event event;


	@Column(name = "create_date")
	private String createDate;



	
	// C O N S T R U C T O R S
	public EventImg() {
		super();
	}



	// G E T T E R S _ A N D _ S E T T E R S
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getEventImgUrl() {
		return eventImgUrl;
	}
	public void setEventImgUrl(String eventImgUrl) {
		this.eventImgUrl = eventImgUrl;
	}

	public String getEventImgName() {
		return eventImgName;
	}
	public void setEventImgName(String eventImgName) {
		this.eventImgName = eventImgName;
	}

	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}

	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}



	// A D D E R S

	
}	

