package tests;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.User;

public class RelationsTest {
	EntityManagerFactory emf;
	EntityManager em;

	@Before
	public void setUp() throws Exception {
		emf = Persistence.createEntityManagerFactory("DeadlinerJPA");
		em = emf.createEntityManager();	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testUser() {
		User u = em.find(User.class, 1);
		assertEquals(u.getName(), "test");
	}

}
