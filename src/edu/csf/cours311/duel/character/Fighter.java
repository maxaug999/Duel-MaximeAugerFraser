package edu.csf.cours311.duel.character;

import java.util.ArrayList;

import educ.csf.cours311.duel.capacity.Capacity;

public abstract class Fighter {
	
	private final int HP_BASE_VALUE = 200;
	private final int MAX_STATS = 100; 
	private String name;
	private Stats myStats;
	private ArrayList<Capacity> capacityList = new ArrayList<Capacity>();
	private int hp; // Point de vie
	
	Fighter(String name, Stats stats, Capacity capacity){
		this.name = name;
		validateStats(stats);
		this.myStats = stats;
		this.capacityList.add(capacity);
		this.hp = HP_BASE_VALUE - (this.myStats.getForce() + this.myStats.getDexterity() + 
				this.myStats.getIntelligence() + this.myStats.getConcentration());
	}
	
	private void validateStats(Stats stats) {
		if((stats.getForce() + stats.getIntelligence() + stats.getDexterity() + stats.getConcentration()) > 
		MAX_STATS) { 
			throw new IllegalStatException();
		}
	}
	
	public ArrayList<Capacity> getArrayListCapacity(){
		return this.capacityList;
	}
	
	public void addCapacity(Capacity capacity) {
		this.capacityList.add(capacity);
	}
	
	public void removeCapacity(int index) {
		this.capacityList.remove(index);
	}
	
	public Capacity getCapacity(int index) {
		return this.capacityList.get(index);
	}
	
	public int useCapacity(int index) {
		return this.capacityList.get(index).calculatePower(this.myStats);
	}
	
	public Stats getStats() {
		return this.myStats;
	}
	
	public void setHp(int hp) {
		this.hp = hp;
	}
	
	public int getHp() {
		return this.hp;
	}
	
	public int getForce() {
		return this.myStats.getForce();
	}
	
	public int getDexterity() {
		return this.myStats.getDexterity();
	}
	
	public int getIntelligence() {
		return this.myStats.getIntelligence();
	}
	
	public int getConcentration() {
		return this.myStats.getConcentration();
	}

	public String getName() {
		return this.name;
	}
	
	public String toString() {
		return "Name: " + this.name + " Stats = " + this.myStats + " Capacity = " + this.capacityList;
	}
}
