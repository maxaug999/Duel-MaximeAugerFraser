package edu.csf.cours311.duel.character;

public class Stats {
	private int force;
	private int dexterity;
	private int intelligence;
	private int concentration;
	
	public Stats(int force, int dexterity, int intelligence, int concentration){
		this.force = force;
		this.dexterity = dexterity;
		this.intelligence = intelligence;
		this.concentration = concentration;
	}
	
	public void incrementsStats() {
		this.force++;
		this.dexterity++;
		this.intelligence++;
		this.concentration++;
	}
	
	public void decreaseStats() {
		this.force--;
		this.dexterity--;
		this.intelligence--;
		this.concentration--;
	}
	
	public int getForce() {
		return this.force;
	}
	
	public int getDexterity() {
		return this.dexterity;
	}
	
	public int getIntelligence() {
		return this.intelligence;
	}
	
	public int getConcentration() {
		return this.concentration;
	}
	
}
