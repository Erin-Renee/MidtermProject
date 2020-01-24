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
@Table(name="user")
public class User {

	// F I E L D S
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;


	@Column(name = "username")
	private String username;


	@Column(name = "password")
	private String password;


	@Column(name = "active")
	private Boolean active;


	@Column(name = "role")
	private String role;


	@Column(name = "first_name")
	private String firstName;


	@Column(name = "last_name")
	private String lastName;


	@Column(name = "email")
	private String email;


	@ManyToOne
	@JoinColumn(name = "location_id")
	private Location location;


	@Column(name = "create_date")
	private String createDate;


	@Column(name = "user_img_url")
	private String userImgUrl;


	@OneToMany(mappedBy="user")
	private List<UserDetails> userDetailss;


	@OneToMany(mappedBy="user")
	private List<UserEvent> userEvents;


	@OneToMany(mappedBy="user")
	private List<GroupComment> groupComments;


	@OneToMany(mappedBy="user")
	private List<EventComment> eventComments;


	@OneToMany(mappedBy="user")
	private List<Group> groups;



	
	// C O N S T R U C T O R S
	public User() {
		super();
	}



	// G E T T E R S _ A N D _ S E T T E R S
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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

	public String getUserImgUrl() {
		return userImgUrl;
	}
	public void setUserImgUrl(String userImgUrl) {
		this.userImgUrl = userImgUrl;
	}

	public List<UserDetails> getUserDetailss() {
		return userDetailss;
	}
	public void setUserDetailss(List<UserDetails> userDetailss) {
		this.userDetailss = userDetailss;
	}

	public List<UserEvent> getUserEvents() {
		return userEvents;
	}
	public void setUserEvents(List<UserEvent> userEvents) {
		this.userEvents = userEvents;
	}

	public List<GroupComment> getGroupComments() {
		return groupComments;
	}
	public void setGroupComments(List<GroupComment> groupComments) {
		this.groupComments = groupComments;
	}

	public List<EventComment> getEventComments() {
		return eventComments;
	}
	public void setEventComments(List<EventComment> eventComments) {
		this.eventComments = eventComments;
	}

	public List<Group> getGroups() {
		return groups;
	}
	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}



	// A D D E R S
	public void addUserDetails (UserDetails userDetails) {
		if (userDetailss == null) {
			userDetailss = new ArrayList<>();
		}
		if (!userDetailss.contains(userDetails)) {
			userDetailss.add(userDetails);
			userDetails.setUser(this);
		}
	}
	
	public void addUserEvent (UserEvent userEvent) {
		if (userEvents == null) {
			userEvents = new ArrayList<>();
		}
		if (!userEvents.contains(userEvent)) {
			userEvents.add(userEvent);
			userEvent.setUser(this);
		}
	}
	
	public void addGroupComment (GroupComment groupComment) {
		if (groupComments == null) {
			groupComments = new ArrayList<>();
		}
		if (!groupComments.contains(groupComment)) {
			groupComments.add(groupComment);
			groupComment.setUser(this);
		}
	}
	
	public void addEventComment (EventComment eventComment) {
		if (eventComments == null) {
			eventComments = new ArrayList<>();
		}
		if (!eventComments.contains(eventComment)) {
			eventComments.add(eventComment);
			eventComment.setUser(this);
		}
	}
	
	public void addGroup (Group group) {
		if (groups == null) {
			groups = new ArrayList<>();
		}
		if (!groups.contains(group)) {
			groups.add(group);
			group.setUser(this);
		}
	}
	

	
}	

