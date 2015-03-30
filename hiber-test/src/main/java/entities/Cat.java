package entities;


public class Cat extends Pet {
	
	public Double getVolume() {
		return volume;
	}
	
	public void setVolume(Double volume) {
		this.volume = volume;
	}
	
	/* [0.0, 1.0] */
	private Double volume;
}
