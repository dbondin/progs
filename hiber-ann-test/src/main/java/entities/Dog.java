package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Dog extends Pet {
	
	public Boolean getTrained() {
		return trained;
	}
	
	public void setTrained(Boolean trained) {
		this.trained = trained;
	}
	
	@Column
	private Boolean trained;
}
