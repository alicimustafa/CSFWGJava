package test;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.Rank;

public class RankTest {

	private EntityManagerFactory emf = null;
	private EntityManager em = null;
	private Rank ra;
	
	@Before
	public void setUp() {
		emf = Persistence.createEntityManagerFactory("csfwgPU");
		em = emf.createEntityManager();
		ra = em.find(Rank.class, 1);
	}
	
	@After
	public void teatDown() {
		em.close();
		emf.close();
		ra = null;
	}
	
	@Test
	public void smokeTest() {
		assertEquals(true, true);
	}
	
	@Test
	public void test_Rank_name_mapped() {
		assertEquals("Admin", ra.getName());
	}
	
}
