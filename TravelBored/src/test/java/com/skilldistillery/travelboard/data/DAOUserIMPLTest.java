package com.skilldistillery.travelboard.data;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.skilldistillery.travelboard.entities.Location;
import com.skilldistillery.travelboard.entities.User;
import com.skilldistillery.travelboard.entities.UserRole;

public class DAOUserIMPLTest {
	DAOUserIMPL dao = new DAOUserIMPL();

	public static void main(String[] args) {
		DAOUserIMPLTest test = new DAOUserIMPLTest();

		test.testUpdate();

		System.out.println("done");

	}

	public void testCreate() {
		DAOUserIMPL dao = new DAOUserIMPL();

		User user = new User();

		user.setFirstName("Bob");
		user.setLastName("Johnson");
		user.setEmail("bobjohnson@user.com");
		user.setUsername("BobbaUsername");
		user.setPassword("password");
		user.setActive(true);
		user.setRole(UserRole.user);
		user.setUserDetails(null);
		user.setUserEvents(null);
		user.setEventComments(null);
		user.setGroups(null);
		user.setGroupComments(null);
		user.setUserImgUrl(null);
		Location loc = new Location();
		loc.setId(1);
		user.setLocation(loc);

		dao.create(user);

	}

	public void testDelete() {
		int id = 6;

		dao.delete(id);

	}

	public void testUpdate() {
		User user = new User();

		user.setFirstName("Jack");
		user.setLastName("Johnson");
		user.setEmail("Jackjohnson@user.com");
		user.setUsername("JackUsername");
		user.setPassword("password");
		user.setActive(true);
		user.setRole(UserRole.user);
		user.setUserDetails(null);
		user.setUserEvents(null);
		user.setEventComments(null);
		user.setGroups(null);
		user.setGroupComments(null);
		user.setUserImgUrl(null);
		Location loc = new Location();
		loc.setId(1);
		user.setLocation(loc);
		
		int id = 4;
		
		dao.updateBasicUserInfo(user, id);
	}

	public void testRead1() {

	}

	public void testRead2() {

	}

}
