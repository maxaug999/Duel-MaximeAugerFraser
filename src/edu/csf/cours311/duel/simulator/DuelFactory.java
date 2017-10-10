package edu.csf.cours311.duel.simulator;

import edu.csf.cours311.duel.character.Athlete;
import edu.csf.cours311.duel.character.Fighter;
import edu.csf.cours311.duel.character.Magician;
import edu.csf.cours311.duel.character.Stats;
import edu.csf.cours311.duel.character.Warrior;
import educ.csf.cours311.duel.capacity.Capacity;
import educ.csf.cours311.duel.capacity.Cure;
import educ.csf.cours311.duel.capacity.Shield;
import educ.csf.cours311.duel.capacity.SpellDef;
import educ.csf.cours311.duel.capacity.SpellHeal;
import educ.csf.cours311.duel.capacity.SpellOff;
import educ.csf.cours311.duel.capacity.Sword;

public class DuelFactory {
	
	public Capacity createCapacity(String capacityType, int carac) {
		if(capacityType.equals("Cure")) {
			return new Cure(carac);
		}
		if(capacityType.equals("Shield")) {
			return new Shield(carac);
		}
		if(capacityType.equals("SpellDef")) {
			return new SpellDef(carac);
		}
		if(capacityType.equals("SpellHeal")) {
			return new SpellHeal(carac);
		}
		if(capacityType.equals("SpellOff")) {
			return new SpellOff(carac);
		}
		if(capacityType.equals("Sword")) {
			return new Sword(carac);
		}
		return null;
	}
	
	public Fighter createFighter(String fighterType,String name, Stats stats, Capacity capacity) {
		if(fighterType.equals("Athlete")) {
			return new Athlete(name, stats, capacity);
		}
		if(fighterType.equals("Magician")) {
			return new Magician(name, stats, capacity);
		}
		if(fighterType.equals("Warrior")) {
			return new Warrior(name, stats, capacity);
		}
		return null;
	}
	
	public Stats createStats(int force, int dex, int intel, int con) {
		return new Stats(force,dex,intel,con);
	}
}
