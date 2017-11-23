package test;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.GroupMembers;

public class GroupMemberTest {

	EntityManagerFactory emf = null;
	EntityManager em = null;
	GroupMembers gm;
	
	@Before
	public void setUp() {
		emf = Persistence.createEntityManagerFactory("csfwgPU");
		em = emf.createEntityManager();
		gm = em.find(GroupMembers.class, 1);
	}
	
	@After
	public void tearDown() {
		em.close();
		emf.close();
		gm = null;
	}
	
	@Test
	public void smokeTest() {
		assertEquals(true, true);
	}
	
	@Test
	public void test_groupMember_member_mapped() {
		assertEquals("Jody", gm.getMember().getFirstName());
	}
	
	@Test
	public void test_groupMember_group_mapped() {
		assertEquals("Sunday group", gm.getGroup().getName());
	}
}
