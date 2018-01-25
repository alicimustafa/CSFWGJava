package entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;

	@JsonManagedReference(value="memberToLogin")
	@OneToOne(mappedBy = "member")
	private Login login;
	
	@JsonIgnore
	@OneToMany(mappedBy="member")
	private List<Archive> archive;
	
	@JsonIgnore
	@OneToMany(mappedBy ="member")
	private List<DuePayment> duePayments;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "members")
	private List<Group> groups;

	@JsonBackReference(value="memberProfile")
	@OneToOne(mappedBy="member")
	private Profile profile;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public List<Archive> getArchive() {
		return archive;
	}

	public void setArchive(List<Archive> archive) {
		this.archive = archive;
	}

	public List<DuePayment> getDuePayments() {
		return duePayments;
	}

	public void setDuePayments(List<DuePayment> duePayments) {
		this.duePayments = duePayments;
	}

	public List<Group> getGroups() {
		return groups;
	}

	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	
}
