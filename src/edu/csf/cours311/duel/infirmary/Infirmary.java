package edu.csf.cours311.duel.infirmary;

import edu.csf.cours311.duel.character.Fighter;
import edu.csf.cours311.duel.duel.IllegalIndexCapacityListException;
import educ.csf.cours311.duel.capacity.Capacity;
import educ.csf.cours311.duel.capacity.Cure;
import educ.csf.cours311.duel.capacity.Heal;
import educ.csf.cours311.duel.capacity.SpellHeal;

public class Infirmary {

	Fighter patient;
	
	public Infirmary(Fighter fighter) {
		this.patient = fighter;
	}
	
	public void heal(int index) {
		validateIndexOfCapacityList(index);
		validateCapacityForInfirmary(index);
		patient.setHp(patient.getHp() + patient.useCapacity(index));
		patient.removeCapacity(index);
	}
	
	private void validateCapacityForInfirmary(int index) {
		if(patient.getCapacity(index).getClass() != Cure.class && 
				patient.getCapacity(index).getClass() != SpellHeal.class) {
			throw new IllegalCapacityForInfirmaryException();
		}
	}
	
	private void validateIndexOfCapacityList(int capacityIndex) {
		if(capacityIndex > patient.getArrayListCapacity().size()) {
			throw new IllegalIndexCapacityListException();
		}
		if(capacityIndex < 0) {
			throw new IllegalIndexCapacityListException();
		}
	}
}
