package builders;

import java.sql.Date;

import entities.Archive;
import entities.Member;

public class ArchiveBuilder {

	private Archive ar;
	
	public ArchiveBuilder() {
		ar = new Archive();
	}
	
	public ArchiveBuilder id(int id) {
		ar.setId(id);
		return this;
	}
	
	public ArchiveBuilder path(String path) {
		ar.setPath(path);
		return this;
	} 
	
	public ArchiveBuilder member(Member member) {
		ar.setMember(member);
		return this;
	}
	
	public ArchiveBuilder submitDate(Date submitDate) {
		ar.setSubmitDate(submitDate);
		return this;
	}
	
	public ArchiveBuilder description(String desc) {
		ar.setDescription(desc);
		return this;
	}
	
	public Archive build() {
		return ar;
	}
}
