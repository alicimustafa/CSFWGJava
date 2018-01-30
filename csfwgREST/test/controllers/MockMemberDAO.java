package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import data.MemberDAO;
import entities.Login;
import entities.Member;
import entities.Rank;

public class MockMemberDAO implements MemberDAO {

	private List<Member> memList;
	private List<Rank> rankList;
	private List<Login> loginList;
	
	public MockMemberDAO() {
		
	}
	
	public void init() {
		memList = new ArrayList<>();
		rankList = new ArrayList<>();
		loginList = new ArrayList<>();
		rankInit();
		memInit();
		logInit();
	}
	
	private void logInit() {
		Login lo = new Login();
		lo.setId(1);
		lo.setPassword("1234");
		lo.setUsername("jody@gmail.com");
		lo.setMember(this.memList.get(0));
		lo = new Login();
		lo.setId(1);
		lo.setPassword("1234");
		lo.setUsername("henry@gmail.com");
		lo.setMember(this.memList.get(1));
		lo = new Login();
		lo.setId(2);
		lo.setPassword("1234");
		lo.setUsername("kurt@gmail.com");
		lo.setMember(this.memList.get(2));
	}
	
	private void rankInit() {
		Rank ra = new Rank();
		ra.setId(1);
		ra.setName("Admin");
		this.rankList.add(ra);
		ra = new Rank();
		ra.setId(2);
		ra.setName("Officer");
		this.rankList.add(ra);
		ra = new Rank();
		ra.setId(3);
		ra.setName("Member");
		this.rankList.add(ra);
	}
	
	private void memInit() {
		Member mem = new Member();
		mem.setId(1);
		mem.setFirstName("Jody");
		mem.setLastName("Morgan");
		mem.setRank(this.rankList.get(0));
		mem = new Member();
		mem.setId(2);
		mem.setFirstName("Henry");
		mem.setLastName("Olson");
		mem.setRank(this.rankList.get(1));
		mem = new Member();
		mem.setId(3);
		mem.setFirstName("Kurt");
		mem.setLastName("Frazier");
		mem.setRank(this.rankList.get(2));
	}
	
	@Override
	public Member loginMember(String json) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			Login mapedLogin = mapper.readValue(json, Login.class);
			for(Login l: this.loginList) {
				if(l.getUsername().equals(mapedLogin.getUsername())) {
					if(l.getPassword().equals(mapedLogin.getPassword())) {
						return l.getMember();
					}
				}
			}
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Member registerMember(String json) {
		// TODO Auto-generated method stub
		
		return null;
	}

}
