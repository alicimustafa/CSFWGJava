package controllers;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import builders.LoginBuilder;
import builders.MemberBuilder;
import builders.RankBuilder;
import data.MemberDAO;
import entities.Login;
import entities.Member;
import entities.Rank;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations = { "AuthControllersTest-context.xml" })  
@WebAppConfiguration  
public class AuthControllersTest {

	private MockMvc mockMvc;
	
	@Autowired
	private MemberDAO dao;
	
	@Test
	public void login_returns_correct_json_if_correct_login() {
		Login log = new LoginBuilder().username("jody@gmail.com").password("1234").build();
		Rank rank = new RankBuilder().id(1).name("Admin").build();
		Member member = new MemberBuilder()
				.firstName("Jody")
				.lastName("Morgan")
				.id(1)
				.rank(rank)
				.build();
		
		when(dao.loginMember("")).thenReturn(member);
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
			verify(dao, times(1)).loginMember("");
	        verifyNoMoreInteractions(dao);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void login_returns_405_if_login_info_incorrect_password() {
		Login log = new LoginBuilder().username("jody@gmail.com").password("2234").build();
		when(dao.loginMember("")).thenReturn(null);
		try {
			mockMvc.perform(post("auth/login")
					.contentType(TestUtil.APPLICATION_JSON_UTF8)
					.content(TestUtil.convertObjectToJsonBytes(log)))
					.andExpect(status().is4xxClientError());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
