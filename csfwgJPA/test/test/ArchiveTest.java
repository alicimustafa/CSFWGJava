package test;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.Archive;

public class ArchiveTest {

	private EntityManagerFactory emf = null;
	private EntityManager em = null;
	private Archive arc;
	
	@Before
	public void setUp() {
		emf = Persistence.createEntityManagerFactory("csfwgPU");
		em = emf.createEntityManager();
		arc = em.find(Archive.class, 1);
	}
	
	@After
	public void teatDown() {
		em.close();
		emf.close();
		arc = null;
	}
	
	@Test
	public void smokeTest() {
		assertEquals(true,true);
	}
	
	@Test
	public void test_Archive_path_mapped() {
		assertEquals("path", arc.getPath());
	}
	
	@Test
	public void test_Archive_description_mapped() {
		assertEquals("stuf", arc.getDescription());
	}
	
	@Test
	public void test_Archive_submitDate_mapped() {
		assertEquals("2017-11-22", arc.getSubmitDate().toString());
	}
	
	@Test
	public void test_Archive_member_mapped() {
		assertEquals("Jody", arc.getMember().getFirstName());
	}
}
