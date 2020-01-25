package com.skilldistillery.travelboard.data;

import java.util.List;

import com.skilldistillery.travelboard.entities.Group;

public interface DAOGroup {
	
	public Group create(Group group);
	public boolean delete(int groupId);
	public Group update(Group group, int groupId);
	public List<Group> read(String keyword);

}
