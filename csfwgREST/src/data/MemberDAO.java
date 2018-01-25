package data;

import entities.Member;

public interface MemberDAO {
	
	public Member loginMember(String json);
	public Member registerMember(String json);
	
}
