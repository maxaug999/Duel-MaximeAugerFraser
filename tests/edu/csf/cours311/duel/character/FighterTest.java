package edu.csf.cours311.duel.character;

import static org.junit.Assert.*;

import org.junit.Test;

import educ.csf.cours311.duel.capacity.Capacity;
import educ.csf.cours311.duel.capacity.Cure;
import educ.csf.cours311.duel.capacity.SpellHeal;
import educ.csf.cours311.duel.capacity.Sword;


public class FighterTest {

	@Test
	public void whenFighterIsCreated_capacityIsReturned() {
		//arrange
		Stats warriorStats = new Stats(30,20,10,10);
		Capacity sword = new Sword(20);
		
		//act
		Fighter aWarrior = new Warrior("Max", warriorStats, sword);
		assertEquals(sword,aWarrior.getCapacity(0)); // Index 0 of arrayList
	}
	
	@Test
	public void whenFighterIsCreated_statsAreReturned() {
		//arrange
		Stats myStats = new Stats(30,20,10,10);
		Capacity sword = new Sword(20);
		
		//act
		Fighter aWarrior = new Warrior("Max", myStats,sword);
		
		//Assert
		final int EXPECTED_FORCE = 30;
		final int EXPECTED_DEXTERITY = 20;
		final int EXPECTED_INTELLIGENCE = 10;
		final int EXPECTED_CONCENTRATION = 10;
		assertEquals(EXPECTED_FORCE,aWarrior.getForce());
		assertEquals(EXPECTED_DEXTERITY,aWarrior.getDexterity());	
		assertEquals(EXPECTED_INTELLIGENCE,aWarrior.getIntelligence());	
		assertEquals(EXPECTED_CONCENTRATION,aWarrior.getConcentration());	
	}

	@Test (expected = IllegalStatException.class)
	public void whenFighterIsCreated_withTooMuchStats_ThenIllegalStatExceptionIsRaised() {
		//arrange
		Stats myStats = new Stats(25,25,25,26);
		Capacity sword = new Sword(20);
		//act
		new Warrior("Max", myStats,sword);
		
		//Assert	
	}
	
	@Test (expected = IllegalStatException.class)
	public void whenOneWarriorIsCreated_withNotEnoughForce_ThenIllegalStatExceptionIsRaised() {
		//arrange
		Stats myStats = new Stats(29,20,10,5);
		Capacity sword = new Sword(20);
		//act
		new Warrior("Max", myStats,sword);
		
		//Assert	
	}
	
	@Test (expected = IllegalStatException.class)
	public void whenOneAthleteIsCreated_withNotEnoughForce_ThenIllegalStatExceptionIsRaised() {
		//arrange
		Stats myStats = new Stats(19,20,20,20);
		Capacity sword = new Sword(20);
		//act
		new Athlete("Max", myStats,sword);
		
		//Assert	
	}
	
	@Test
	public void GIVEN_aFighter_WHEN_fighterAddCapacity_THEN_newCapacityIsReturned() {
		//arrange
		Stats myStats = new Stats(30,20,10,10);
		Capacity sword = new Sword(20);
		Fighter aWarrior = new Warrior("Max", myStats,sword);
		
		//act
		Cure cure = new Cure(20);
		aWarrior.addCapacity(cure);
		
		//Assert
		final int EXPECTED_NEW_CAPACITY_INDEX = 1;
		assertEquals(cure, aWarrior.getCapacity(EXPECTED_NEW_CAPACITY_INDEX));
	}
	
	@Test
	public void GIVEN_aFighter_WHEN_fighterRemoveCapacity_THEN_capacityIsRemovedAndCapacityListEmpty() {
		//arrange
		Stats myStats = new Stats(30,20,10,10);
		Capacity sword = new Sword(20);
		Fighter aWarrior = new Warrior("Max", myStats,sword);
		
		//act
		final int CAPACITY_INDEX_TO_REMOVE = 0;
		aWarrior.removeCapacity(CAPACITY_INDEX_TO_REMOVE);
		
		//Assert
		assertTrue(aWarrior.getArrayListCapacity().isEmpty());
	}
	
}
