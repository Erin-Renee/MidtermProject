package com.skilldistillery.travelboard.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UserEventId implements Serializable{
		private static final long serialVersionUID = 1L;
		
		@Column(name = "user_id")
		private int userId;
		
		@Column(name = "event_id")
		private int eventId;

}
