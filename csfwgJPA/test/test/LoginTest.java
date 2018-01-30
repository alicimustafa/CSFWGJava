package test;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.Login;

public class LoginTest {

	private EntityManagerFactory emf = null;
	private EntityManager em = null;
	private Login log;
	
	@Before
	public void setUp() {
		emf = Persistence.createEntityManagerFactory("csfwgPU");
		em = emf.createEntityManager();
		log = em.find(Login.class, 1);
	}
	
	@After
	public void tearDown() {
		em.close();
		emf.close();
		log = null;
	}
	
	@Test
	public void smokeTest() {
		assertEquals(true, true);
	}
	
	@Test
	public void test_Login_username_mapped() {
		assertEquals("jody@gmail.com", log.getUsername());
	}
	
	@Test
	public void test_Login_password_mapped() {
		assertEquals("1234", log.getPassword());
	}
	
	@Test
	public void test_Login_member_mapped() {
		assertEquals("Jody", log.getMember().getFirstName());
	}
}
