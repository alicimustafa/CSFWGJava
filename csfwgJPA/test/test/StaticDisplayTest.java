package test;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.StaticDisplay;

public class StaticDisplayTest {

	private EntityManagerFactory emf;
	private EntityManager em;
	private StaticDisplay sd;
	
	@Before
	public void setUp() {
		emf = Persistence.createEntityManagerFactory("csfwgPU");
		em = emf.createEntityManager();
		sd = em.find(StaticDisplay.class, 1);
	}
	
	@After
	public void tearDown() {
		em.close();
		emf.close();
		sd = null;
	}
	
	@Test
	public void smokeTest() {
		assertEquals(true, true);
	}
	
	@Test
	public void test_StaticDisplay_location_mapped() {
		assertEquals(sd.getLocation(),"stuff");
	}
	
	@Test
	void test_StaticDisplay_content_mapped() {
		assertEquals(sd.getContent(), "yippy");
	}
	
	@Test
	void test_StaticDisplay_tag_mapped() {
		assertEquals(sd.getTag(), "p");
	}
	
	@Test
	void test_StaticDisplay_order_mapped() {
		assertEquals(sd.getOrder(), 1);
	}
}
