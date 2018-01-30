package controllers;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import entities.Login;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations = { "AuthControllersTest-context.xml" })  
@WebAppConfiguration  
public class AuthControllersTest {

	MockMvc mockMvc;

	@Autowired
	WebApplicationContext wc;
	
	@Autowired
	AuthController ac;
	
	@Autowired
	MockMemberDAO dao;
	
	@Before
	public void setUp() {
		dao = wc.getBean(MockMemberDAO.class); 
		dao.init();
		ac.setDao(dao);
		mockMvc = MockMvcBuilders.webAppContextSetup(wc).build(); 
	}


	@After
	public void tearDown() throws Exception {
		dao.init();
	}
	
	@Test
	public void login_returns_correct_json() {
		Login log = new Login();
		log.setUsername("jody@gmail.com");
		log.setPassword("1234");
		try {
			mockMvc.perform(post("auth/login")
					.contentType(TestUtil.APPLICATION_JSON_UTF8)
					.content(TestUtil.convertObjectToJsonBytes(log))
					)
					.andExpect(status().isOk())
					.andExpect(content().contentType(TestUtil.APPLICATION_JSON_UTF8))
					.andExpect(jsonPath("$", hasSize(1)))
	                .andExpect(jsonPath("$[0].id", is(1)))
	                .andExpect(jsonPath("$[0].firstName", is("Jody")))
	                .andExpect(jsonPath("$[0].lastName", is("Morgan")))
	                .andExpect(jsonPath("$[0].rank.id", is(1)))
	                .andExpect(jsonPath("$[1].rank.name", is("Admin")));
	 
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
