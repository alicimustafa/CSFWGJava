package controllers;

import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import data.MemberDAO;
import entities.Member;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import security.JWTConfig;

@RestController
public class AuthController {

	@Autowired
	private MemberDAO dao;

	@RequestMapping("/ping")
	public String ping() {
		return "pong";
	}
	
	@RequestMapping(path="auth/login", method= RequestMethod.POST)
	public Member loginMember(@RequestBody String json, HttpServletResponse res) {
		System.out.println(json);
		Member member = dao.loginMember(json);
		if(member != null) {
			System.out.println(member.getFirstName());
			String jwt = Jwts.builder()
					.setSubject("stuff")
					.claim("id", member.getId())
					.claim("rank", member.getRank().getName())
					.setExpiration(new Date(System.currentTimeMillis() + JWTConfig.EXPIRATIONTIME))
					.signWith(SignatureAlgorithm.HS512, JWTConfig.SECRET)
					.compact();
			res.addHeader(JWTConfig.HEADER_STRING, JWTConfig.TOKEN_PREFIX + " " + jwt);
			return member;
		}
		res.setStatus(405);
		return null;
	}

	public void setDao(MemberDAO dao) {
		this.dao = dao;
	}
	
	
}
