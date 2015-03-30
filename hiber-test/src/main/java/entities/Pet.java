package entities;

import java.util.HashSet;
import java.util.Set;

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
	
	private Long id;
	private String name;
	private Integer age;
	private Breed breed;
	private Set<Human> humans = new HashSet<Human>();
}
