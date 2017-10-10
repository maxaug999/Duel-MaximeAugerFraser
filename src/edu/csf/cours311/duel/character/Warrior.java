package edu.csf.cours311.duel.character;

import educ.csf.cours311.duel.capacity.Capacity;

public class Warrior extends Fighter {
	
	Stats myStats;
	
	public Warrior(String name, Stats myStats, Capacity capacity){
		
		super(name, myStats,capacity);
		validateStats(myStats);
	}
	
	private void validateStats(Stats myStats) {
		if(myStats.getForce() < myStats.getDexterity() + 10) { 
			throw new IllegalStatException();
		}
		if(myStats.getDexterity() < myStats.getIntelligence() + 10) { 
			throw new IllegalStatException();
		}
		if(myStats.getIntelligence() < myStats.getConcentration()) { 
			throw new IllegalStatException();
		}
		if(myStats.getConcentration() < 0) {
			throw new IllegalStatException();
		}
	}
}
