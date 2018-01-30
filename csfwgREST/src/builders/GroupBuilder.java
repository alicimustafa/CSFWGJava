package builders;

import java.util.List;

import entities.Group;
import entities.Member;

public class GroupBuilder {

	private Group gr;
	
	public GroupBuilder() {
		gr = new Group();
	}
	
	public GroupBuilder id(int id) {
		gr.setId(id);
		return this;
	}
	
	public GroupBuilder name(String name) {
		gr.setName(name);
		return this;
	}
	
	public GroupBuilder description(String desc) {
		gr.setDescription(desc);
		return this;
	}
	
	public GroupBuilder weekday(int weekday) {
		gr.setWeekday(weekday);
		return this;
	}
	
	public GroupBuilder picture(String picture) {
		gr.setPicture(picture);
		return this;
	}
	
	public GroupBuilder officer(Member officer) {
		gr.setOfficer(officer);
		return this;
	}
	
	public GroupBuilder members(List<Member> members) {
		gr.setMembers(members);
		return this;
	}
	
	public Group build() {
		return gr;
	}
}
