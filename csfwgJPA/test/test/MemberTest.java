package test;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.Member;

public class MemberTest {

	private EntityManagerFactory emf = null;
	private EntityManager em = null;
	private Member mem;
	
	@Before
	public void setUp() {
		emf = Persistence.createEntityManagerFactory("csfwgPU");
		em = emf.createEntityManager();
		mem = em.find(Member.class, 1);
	}
	
	@After
	public void tearDown() {
		em.close();
		emf.close();
		mem = null;
	}
	
	@Test
	public void smokeTest() {
		assertEquals(true, true);
	}
	
	@Test
	public void member_FirstName_mapped() {
		assertEquals("Jody", mem.getFirstName());
	}
	
	@Test
	public void member_LastName_mapped() {
		assertEquals("Morgan", mem.getLastName());
	}
}
