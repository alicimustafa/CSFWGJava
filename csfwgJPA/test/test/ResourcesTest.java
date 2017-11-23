package test;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.Resource;

public class ResourcesTest {

	EntityManagerFactory emf = null;
	EntityManager em = null;
	Resource res;
	
	@Before
	public void setUp() {
		emf = Persistence.createEntityManagerFactory("csfwgPU");
		em = emf.createEntityManager();
		res = em.find(Resource.class, 1);
	}
	
	@After
	public void tearDown() {
		em.close();
		emf.close();
		res = null;
	}
	
	@Test
	public void smokeTest() {
		assertEquals(true, true);
	}
	
	@Test
	public void test_resource_path_mapped() {
		assertEquals("url/res", res.getPath());
	}
	
	@Test
	public void test_resource_title_mapped() {
		assertEquals("book stuf", res.getTitle());
	}
	
	@Test
	public void test_resource_description_mapped() {
		assertEquals("book stuf info", res.getDescription());
	}
}
