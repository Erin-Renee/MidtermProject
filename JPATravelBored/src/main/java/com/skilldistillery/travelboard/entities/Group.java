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
@Table(name="group")
public class Group {

	// F I E L D S
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;


	@Column(name = "title")
	private String title;


	@Column(name = "hook")
	private String hook;


	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;


	@Column(name = "create_date")
	private String createDate;


	@Column(name = "active")
	private Boolean active;


	@OneToMany(mappedBy="group")
	private List<GroupComment> groupComments;



	
	// C O N S T R U C T O R S
	public Group() {
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

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}

	public List<GroupComment> getGroupComments() {
		return groupComments;
	}
	public void setGroupComments(List<GroupComment> groupComments) {
		this.groupComments = groupComments;
	}



	// A D D E R S
	public void addGroupComment (GroupComment groupComment) {
		if (groupComments == null) {
			groupComments = new ArrayList<>();
		}
		if (!groupComments.contains(groupComment)) {
			groupComments.add(groupComment);
			if(groupComment.getGroup() != null){
				groupComment.getGroup().getGroupComments().remove(groupComment);
			}
		}
			groupComment.setGroup(this);
	}
	
	public void removeGroupComment(GroupComment groupComment){
		groupComment.setGroup(null);
		if(groupComments != null){
			groupComments.remove(groupComment);
		}
	
	}
	

	
}	

