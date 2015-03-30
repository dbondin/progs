package entities;

public class Dog extends Pet {
	
	public Boolean getTrained() {
		return trained;
	}
	
	public void setTrained(Boolean trained) {
		this.trained = trained;
	}
	
	private Boolean trained;
}
