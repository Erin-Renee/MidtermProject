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
@Table(name="user_detail")
public class UserDetail {

	// F I E L D S
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;


	@Column(name = "user_detail_name")
	private String userDetailName;


	@Column(name = "user_detail_description")
	private String userDetailDescription;


	@Column(name = "user_detail_url")
	private String userDetailUrl;


	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;



	
	// C O N S T R U C T O R S
	public UserDetail() {
		super();
	}



	// G E T T E R S _ A N D _ S E T T E R S
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserDetailName() {
		return userDetailName;
	}
	public void setUserDetailName(String userDetailName) {
		this.userDetailName = userDetailName;
	}

	public String getUserDetailDescription() {
		return userDetailDescription;
	}
	public void setUserDetailDescription(String userDetailDescription) {
		this.userDetailDescription = userDetailDescription;
	}

	public String getUserDetailUrl() {
		return userDetailUrl;
	}
	public void setUserDetailUrl(String userDetailUrl) {
		this.userDetailUrl = userDetailUrl;
	}

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}



	// A D D E R S

	
}	

