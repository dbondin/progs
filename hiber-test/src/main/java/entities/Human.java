package entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Human {

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Set<Pet> getPets() {
		return Pets;
	}
	
	public void setPets(Set<Pet> Pets) {
		this.Pets = Pets;
	}
	
	private Long id;
	private String name;
	private Date dob;
	private Set<Pet> Pets = new HashSet<Pet>();
}
