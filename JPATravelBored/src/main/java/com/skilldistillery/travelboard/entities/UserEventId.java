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
		

		public UserEventId() {
			super();
		}

		public int getUserId() {
			return userId;
		}

		public void setUserId(int userId) {
			this.userId = userId;
		}

		public int getEventId() {
			return eventId;
		}

		public void setEventId(int eventId) {
			this.eventId = eventId;
		}

		public UserEventId(int userId, int eventId) {
			super();
			this.userId = userId;
			this.eventId = eventId;
		}

}
