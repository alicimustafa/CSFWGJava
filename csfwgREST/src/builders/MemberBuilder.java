package builders;

import java.util.List;

import entities.Archive;
import entities.DuePayment;
import entities.Group;
import entities.Member;
import entities.Profile;
import entities.Rank;

public class MemberBuilder {

	Member mem;
	
	public MemberBuilder() {
		mem = new Member();
	}
	
	public MemberBuilder id(int id) {
		mem.setId(id);
		return this;
	}
	
	public MemberBuilder firstName(String firstName) {
		mem.setFirstName(firstName);
		return this;
	}
	
	public MemberBuilder lastName(String lastName) {
		mem.setLastName(lastName);
		return this;
	}
	
	public MemberBuilder rank(Rank rank) {
		mem.setRank(rank);
		return this;
	}
	
	public MemberBuilder archive(List<Archive> archive) {
		mem.setArchive(archive);
		return this;
	}
	
	public MemberBuilder duePayments(List<DuePayment> duePayments) {
		mem.setDuePayments(duePayments);
		return this;
	}
	
	public MemberBuilder groups(List<Group> groups) {
		mem.setGroups(groups);
		return this;
	}
	
	public MemberBuilder profile(Profile profile) {
		mem.setProfile(profile);
		return this;
	}
	
	public Member build() {
		return mem;
	}
}
