package test;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.DuePayment;

public class DuePaymentTest {

	private EntityManagerFactory emf = null;
	private EntityManager em;
	private DuePayment dp;
	
	@Before
	public void setUp() {
		emf = Persistence.createEntityManagerFactory("csfwgPU");
		em = emf.createEntityManager();
		dp = em.find(DuePayment.class, 1);
	}
	
	@After
	public void tearDown() {
		em.close();
		emf.close();
		dp = null;
	}
	
	@Test
	public void smokeTest() {
		assertEquals(true, true);
	}
	
	@Test
	public void test_duePayment_paymentDate_mapped() {
		assertEquals("2017-10-22", dp.getPaymentDate().toString());
	}
	
	@Test
	public void test_duePayment_year_mapped() {
		assertEquals(2017, dp.getYear());
	}
	
	@Test
	public void test_duePayment_vouch_mapped() {
		assertEquals(2, dp.getVouch());
	}
	
	@Test
	public void test_duePayment_member_mapped() {
		assertEquals("Jody", dp.getMember().getFirstName());
	}
}
