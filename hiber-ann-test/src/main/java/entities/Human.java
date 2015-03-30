package entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.JoinColumnOrFormula;

@Entity
@SequenceGenerator(name = "human_seq")
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

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "human_seq")
	private Long id;

	@Column
	private String name;

	@Column
	private Date dob;

	@ManyToMany
	@JoinTable(name = "pet_2_human", joinColumns = @JoinColumn(name = "human_id"), inverseJoinColumns = @JoinColumn(name = "pet_id"))
	private Set<Pet> Pets = new HashSet<Pet>();
}
