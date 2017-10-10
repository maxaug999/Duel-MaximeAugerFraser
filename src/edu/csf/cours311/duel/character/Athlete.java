package edu.csf.cours311.duel.character;

import educ.csf.cours311.duel.capacity.Capacity;

public class Athlete extends Fighter {
	
	private final int MIN_STATS = 20;
	
	Stats myStats;
	
	public Athlete(String name, Stats myStats, Capacity capacity){
		super(name, myStats, capacity);
		validateStats(myStats);
	}
	
	private void validateStats(Stats myStats) {
		if(myStats.getForce() < MIN_STATS) {throw new IllegalStatException();}
		if(myStats.getDexterity() < MIN_STATS) {throw new IllegalStatException();}
		if(myStats.getIntelligence() < MIN_STATS) {throw new IllegalStatException();}
		if(myStats.getConcentration() < MIN_STATS) {throw new IllegalStatException();}
	}
}
