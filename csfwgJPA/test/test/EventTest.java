package test;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.Event;

public class EventTest {

	private EntityManagerFactory emf;
	private EntityManager em;
	private Event ev;
	
	@Before
	public void setUp() {
		emf = Persistence.createEntityManagerFactory("csfwgPU");
		em = emf.createEntityManager();
		ev = em.find(Event.class, 13);
	}
	
	@After
	public void tearDown() {
		em.close();
		emf.close();
		ev = null;
	}
	
	@Test
	public void smokeTest() {
		assertEquals(true, true);
	}
	
	@Test
	public void test_event_title_mapped() {
		assertEquals("pikes peek confrince", ev.getTitle());
	}
	
	@Test
	public void test_event_date_mapped() {
		assertEquals("2016-05-16", ev.getDate().toString());
	}
	
	@Test
	public void test_event_dateEnd_mapped() {
		assertEquals("2016-05-18", ev.getEventEnd().toString());
	}
	
	@Test
	public void test_event_repeatType_mapped() {
		assertEquals(1, ev.getRepeatType());
	}
	
	@Test
	public void test_event_eventType_mapped() {
		assertEquals(null, ev.getEventType());
	}
	
	@Test
	public void test_event_description_mapped() {
		assertEquals(null, ev.getDescription());
	}
}
