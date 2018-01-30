package builders;

import entities.Login;
import entities.Member;

public class LoginBuilder {

	private Login log;
	
	public LoginBuilder() {
		log = new Login();
	}
	
	public LoginBuilder id(int id) {
		log.setId(id);
		return this;
	}
	
	public LoginBuilder username(String username) {
		log.setUsername(username);
		return this;
	}
	
	public LoginBuilder password(String password) {
		log.setPassword(password);
		return this;
	}
	
	public LoginBuilder member(Member member) {
		log.setMember(member);
		return this;
	}
	
	public Login build() {
		return log;
	}
}
