package educ.csf.cours311.duel.capacity;

import edu.csf.cours311.duel.character.Stats;

public abstract class Capacity {
	
	private final int MIN_CARACTERISTIC = 20;
	private final int MAX_CARACTERISTIC = 100;
	
	private int caracPower;
	private Caracteristic caracteristic; //Enum
	
	
	public Capacity(int caracPower, Caracteristic caracteristic){
		validateCaracteristic(caracPower);
		this.caracPower = caracPower;
		this.caracteristic = caracteristic;
	}
	
	public int getCaracPower() {
		return this.caracPower;
	}
	
	public Caracteristic getCaracteristic() {
		return this.caracteristic;
	}
	
	public abstract int calculatePower(Stats stats);
	
	/*
	public int calculatePower2(Stats stats) {
		return (stats.getForce() * this.caracteristic / 100);
	}*/
	
	private void validateCaracteristic(int caracPower) {
		if (caracPower > MAX_CARACTERISTIC) {
			throw new IllegalCaracException();
		}
		if (caracPower < MIN_CARACTERISTIC){
			throw new IllegalCaracException();
		}
	}
}
