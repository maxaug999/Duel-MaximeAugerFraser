package edu.csf.cours311.duel.character;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import educ.csf.cours311.duel.capacity.Capacity;
import educ.csf.cours311.duel.capacity.Sword;

public class AthleteTest {
	
	@Test
	public void whenAthleteIsCreated_NameIsReturned() {
		//arrange
		Stats athleteStats = new Stats(20,20,20,20);
		Capacity sword = new Sword(20);
		
		//act
		Fighter aAthlete = new Athlete("Max",athleteStats, sword);
		
		//Assert
		final String EXPECTED_NAME = "Max";
		assertEquals(EXPECTED_NAME,aAthlete.getName()); //
	}

	
	@Test
	public void whenAthleteIsCreated_capacityIsReturned() {
		//arrange
		Stats athleteStats = new Stats(20,20,20,20);
		Capacity sword = new Sword(20);
		
		//act
		Fighter aAthlete = new Athlete("Max",athleteStats, sword);
		
		//Assert
		assertEquals(sword,aAthlete.getCapacity(0)); // Index 0 of capacityList
	}
	
	@Test
	public void whenAthleteIsCreated_statsAreReturned() {
		//arrange
		Stats athleteStats = new Stats(20,20,20,20);
		Capacity sword = new Sword(20);
		
		//act
		Fighter aAthlete = new Athlete("Max",athleteStats,sword);
		
		//Assert
		final int EXPECTED_FORCE = 20;
		final int EXPECTED_DEXTERITY = 20;
		final int EXPECTED_INTELLIGENCE = 20;
		final int EXPECTED_CONCENTRATION = 20;
		assertEquals(EXPECTED_FORCE,aAthlete.getForce());
		assertEquals(EXPECTED_DEXTERITY,aAthlete.getDexterity());	
		assertEquals(EXPECTED_INTELLIGENCE,aAthlete.getIntelligence());	
		assertEquals(EXPECTED_CONCENTRATION,aAthlete.getConcentration());	
	}
	
	@Test (expected = IllegalStatException.class)
	public void whenAthleteIsCreated_withTooMuchStats_ThenIllegalStatExceptionIsRaised() {
		//arrange
		Stats athleteStats = new Stats(25,25,25,26);
		Capacity sword = new Sword(20);
		//act
		new Athlete("Max",athleteStats,sword);
	}
	
	@Test (expected = IllegalStatException.class)
	public void whenOneAthleteIsCreated_withNotEnoughForce_ThenIllegalStatExceptionIsRaised() {
		//arrange
		Stats athleteStats = new Stats(19,20,20,20);
		Capacity sword = new Sword(20);
		//act
		new Athlete("Max",athleteStats,sword);	
	}
	
	@Test (expected = IllegalStatException.class)
	public void whenOneAthleteIsCreated_withNotEnoughDexterity_ThenIllegalStatExceptionIsRaised() {
		//arrange
		Stats athleteStats = new Stats(20,19,20,20);
		Capacity sword = new Sword(20);
		//act
		new Athlete("Max",athleteStats,sword);	
	}
	
	@Test (expected = IllegalStatException.class)
	public void whenOneAthleteIsCreated_withNotEnoughIntelligence_ThenIllegalStatExceptionIsRaised() {
		//arrange
		Stats athleteStats = new Stats(20,20,19,20);
		Capacity sword = new Sword(20);
		//act
		new Athlete("Max",athleteStats,sword);
	}
	
	@Test (expected = IllegalStatException.class)
	public void whenOneAthleteIsCreated_withNotEnoughConcentration_ThenIllegalStatExceptionIsRaised() {
		//arrange
		Stats athleteStats = new Stats(20,20,20,19);
		Capacity sword = new Sword(20);
		//act
		new Athlete("Max",athleteStats,sword);	
	}
	
}
