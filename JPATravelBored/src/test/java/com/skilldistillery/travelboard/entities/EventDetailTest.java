package com.skilldistillery.travelboard.entities;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EventDetailTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private EventDetail eDetail;
	

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("TravelBored");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		eDetail = em.find(EventDetail.class, 1);
		
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		eDetail = null;
	}

	@Test
	void test() {
		assertNotNull(eDetail);
	}

}
