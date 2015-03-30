package entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name = "pet_seq")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pet {

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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Breed getBreed() {
		return breed;
	}

	public void setBreed(Breed breed) {
		this.breed = breed;
	}

	public Set<Human> getHumans() {
		return humans;
	}

	public void setHumans(Set<Human> humans) {
		this.humans = humans;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pet_seq")
	private Long id;

	@Column
	private String name;

	@Column
	private Integer age;

	@ManyToOne
	private Breed breed;

	@ManyToMany
	@JoinTable(name = "pet_2_human", inverseJoinColumns = @JoinColumn(name = "human_id"), joinColumns = @JoinColumn(name = "pet_id"))
	private Set<Human> humans = new HashSet<Human>();
}
