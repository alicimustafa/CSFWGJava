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
	
	@Test
	public void member_arhive_mapped() {
		assertEquals("path", mem.getArchive().get(0).getPath());
	}
	
	@Test
	public void test_member_duePayments_mapped() {
		assertEquals(1, mem.getDuePayments().size());
	}
	
	@Test
	public void test_member_profile_mapped() {
		assertEquals("555-678-6789", mem.getProfile().getPhone());
	}
	
	@Test
	public void test_member_groups_mapped() {
		assertEquals("Sunday group", mem.getGroups().get(0).getName());
	}
	
	@Test
	public void test_Login_rank_mapped() {
		assertEquals("Admin", mem.getRank().getName());
	}
}
