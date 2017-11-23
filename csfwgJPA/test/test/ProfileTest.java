package test;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.Profile;

public class ProfileTest {

	private EntityManagerFactory emf = null;
	private EntityManager em = null;
	private Profile pr;
	
	@Before
	public void setUp() {
		emf = Persistence.createEntityManagerFactory("csfwgPU");
		em = emf.createEntityManager();
		pr = em.find(Profile.class, 1);
	}
	
	@After
	public void tearDown() {
		em.close();
		emf.close();
		pr = null;
	}
	
	@Test
	public void smokeTest() {
		assertEquals(true, true);
	}
	
	@Test
	public void test_profile_phone_mapped() {
		assertEquals("555-678-6789", pr.getPhone());
	}
	
	@Test
	public void test_profile_address_mapped() {
		assertEquals("123 street", pr.getAddress());
	}
	
	@Test
	public void test_profile_city_mapped() {
		assertEquals("Colorado Springs", pr.getCity());
	}
	
	@Test
	public void test_profile_state_mapped() {
		assertEquals("CO", pr.getState());
	}
	
	@Test
	public void test_profile_zip_mapped() {
		assertEquals("80909", pr.getZip());
	}
	
	@Test
	public void test_profile_privacy_mapped() {
		assertEquals(3, pr.getPrivacy());
	}
	
	@Test
	public void test_profile_picture_mapped() {
		assertEquals("url/pic", pr.getPicture());
	}
	
	@Test
	public void test_profile_quote_mapped() {
		assertEquals("have fun", pr.getQuote());
	}
	
	@Test
	public void test_profile_member_mapped() {
		assertEquals("Jody", pr.getMember().getFirstName());
	}
	
}
