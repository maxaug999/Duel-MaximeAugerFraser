package edu.csf.cours311.duel.character;

import educ.csf.cours311.duel.capacity.Capacity;

public class Magician extends Fighter {
	
	Stats myStats;
	Capacity capacity;
	
	public Magician(String name, Stats myStats, Capacity capacity){
		super(name, myStats, capacity);
		validateStats(myStats);
	}

	private void validateStats(Stats myStats) {
		if(myStats.getIntelligence() < max(myStats.getForce(), myStats.getDexterity()) + 15){
			throw new IllegalStatException();
		}
		if(myStats.getConcentration() < max(myStats.getForce(), myStats.getDexterity()) + 15){
			throw new IllegalStatException();
		}
		if(myStats.getForce() < 0) {
			throw new IllegalStatException();
		}
		if(myStats.getDexterity() < 0) {
			throw new IllegalStatException();
		}
	}
	
	private int max(int force, int dex) {
		if(force >= dex) {
			return force;
		}else {
			return dex;
		}
	}
}
