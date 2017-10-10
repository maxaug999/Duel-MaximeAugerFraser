package edu.csf.cours311.duel.character;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import educ.csf.cours311.duel.capacity.Capacity;
import educ.csf.cours311.duel.capacity.Sword;

public class WarriorTest {
	
	@Test
	public void whenWarriorIsCreated_NameIsReturned() {
		//arrange
		Stats warriorStats = new Stats(30,20,10,5);
		Capacity sword = new Sword(20);
		
		//act
		Fighter aWarrior = new Warrior("Max",warriorStats, sword);
		
		//Assert
		final String EXPECTED_NAME = "Max";
		assertEquals(EXPECTED_NAME,aWarrior.getName()); //
	}

	
	@Test
	public void whenWarriorIsCreated_capacityIsReturned() {
		//arrange
		Stats warriorStats = new Stats(30,20,10,5);
		Capacity sword = new Sword(20);
		
		//act
		Fighter aWarrior = new Warrior("Max",warriorStats, sword);
		
		//Assert
		assertEquals(sword,aWarrior.getCapacity(0)); // Index 0 of capacityList
	}
	
	@Test
	public void whenWarriorIsCreated_statsAreReturned() {
		//arrange
		Stats warriorStats = new Stats(30,20,10,5);
		Capacity sword = new Sword(20);
		
		//act
		Fighter aWarrior = new Warrior("Max",warriorStats,sword);
		
		//Assert
		final int EXPECTED_FORCE = 30;
		final int EXPECTED_DEXTERITY = 20;
		final int EXPECTED_INTELLIGENCE = 10;
		final int EXPECTED_CONCENTRATION = 5;
		assertEquals(EXPECTED_FORCE,aWarrior.getForce());
		assertEquals(EXPECTED_DEXTERITY,aWarrior.getDexterity());	
		assertEquals(EXPECTED_INTELLIGENCE,aWarrior.getIntelligence());	
		assertEquals(EXPECTED_CONCENTRATION,aWarrior.getConcentration());	
	}
	
	@Test (expected = IllegalStatException.class)
	public void whenWarriorIsCreated_withTooMuchStats_ThenIllegalStatExceptionIsRaised() {
		//arrange
		Stats warriorStats = new Stats(25,25,25,26);
		Capacity sword = new Sword(20);
		//act
		new Warrior("Max",warriorStats,sword);
	}
	
	@Test (expected = IllegalStatException.class)
	public void whenOneWarriorIsCreated_withNotEnoughForce_ThenIllegalStatExceptionIsRaised() {
		//arrange
		Stats warriorStats = new Stats(29,20,10,5);
		Capacity sword = new Sword(20);
		//act
		new Warrior("Max",warriorStats,sword);	
	}
	
	@Test (expected = IllegalStatException.class)
	public void whenOneWarriorIsCreated_withNotEnoughDexterity_ThenIllegalStatExceptionIsRaised() {
		//arrange
		Stats warriorStats = new Stats(30,19,10,5);
		Capacity sword = new Sword(20);
		//act
		new Warrior("Max",warriorStats,sword);	
	}
	
	@Test (expected = IllegalStatException.class)
	public void whenOneWarriorIsCreated_withNotEnoughIntelligence_ThenIllegalStatExceptionIsRaised() {
		//arrange
		Stats warriorStats = new Stats(30,20,4,5);
		Capacity sword = new Sword(20);
		//act
		new Warrior("Max",warriorStats,sword);
	}
	
	@Test (expected = IllegalStatException.class)
	public void whenOneWarriorIsCreated_withNotEnoughConcentration_ThenIllegalStatExceptionIsRaised() {
		//arrange
		Stats warriorStats = new Stats(30,20,10,-1);
		Capacity sword = new Sword(20);
		//act
		new Warrior("Max",warriorStats,sword);	
	}
	
}
