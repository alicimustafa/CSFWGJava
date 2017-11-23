package test;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.Group;

public class GroupTest {

	private EntityManagerFactory emf = null;
	private EntityManager em = null;
	private Group gr;
	
	@Before
	public void setUp() {
		emf = Persistence.createEntityManagerFactory("csfwgPU");
		em = emf.createEntityManager();
		gr = em.find(Group.class, 1);
	}
	
	@After
	public void tearDown() {
		em.close();
		emf.close();
		gr = null;
	}
	
	@Test
	public void smokeTest() {
		assertEquals(true, true);
	}
	
	@Test
	public void test_group_name_mapped() {
		assertEquals("Sunday group", gr.getName());
	}
	
	@Test
	public void test_group_description_mapped() {
		assertEquals(null, gr.getDescription());
	}
	
	@Test
	public void test_group_weekday_mapped() {
		assertEquals(1, gr.getWeekday());
	}
	
	@Test
	public void test_group_picture_mapped() {
		assertEquals(null, gr.getPicture());
	}
	
	@Test
	public void test_group_officer_mapped() {
		assertEquals("Jody", gr.getOfficer().getFirstName());
	}
}
