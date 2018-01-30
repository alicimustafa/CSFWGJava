package builders;

import entities.Member;
import entities.Profile;

public class ProfileBuilder {

	private Profile pr;
	
	public ProfileBuilder() {
		pr = new Profile();
	}
	
	public ProfileBuilder id(int id) {
		pr.setId(id);
		return this;
	}
	
	public ProfileBuilder phone(String phone) {
		pr.setPhone(phone);
		return this;
	}
	
	public ProfileBuilder address(String address) {
		pr.setAddress(address);
		return this;
	}
	
	public ProfileBuilder city(String city) {
		pr.setCity(city);
		return this;
	}
	
	public ProfileBuilder state(String state) {
		pr.setState(state);
		return this;
	}
	
	public ProfileBuilder zip(String zip) {
		pr.setZip(zip);
		return this;
	}
	
	public ProfileBuilder privacy(int privacy) {
		pr.setPrivacy(privacy);
		return this;
	}
	
	public ProfileBuilder picture(String picture) {
		pr.setPicture(picture);
		return this;
	}
	public ProfileBuilder quote(String quote) {
		pr.setQuote(quote);
		return this;
	}
	
	public ProfileBuilder member(Member member) {
		pr.setMember(member);
		return this;
	}
	
	public Profile build() {
		return pr;
	}
}
