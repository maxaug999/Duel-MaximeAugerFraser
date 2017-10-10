package edu.csf.cours311.duel.character;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import educ.csf.cours311.duel.capacity.Capacity;
import educ.csf.cours311.duel.capacity.Sword;

public class MagicianTest {
	
	@Test
	public void whenMagicianIsCreated_NameIsReturned() {
		//arrange
		Stats magicianStats = new Stats(5,5,20,20);
		Capacity sword = new Sword(20);
		
		//act
		Fighter aMagician = new Magician("Max",magicianStats, sword);
		
		//Assert
		final String EXPECTED_NAME = "Max";
		assertEquals(EXPECTED_NAME,aMagician.getName()); //
	}

	
	@Test
	public void whenMagicianIsCreated_capacityIsReturned() {
		//arrange
		Stats magicianStats = new Stats(5,5,20,20);
		Capacity sword = new Sword(20);
		
		//act
		Fighter aMagician = new Magician("Max",magicianStats, sword);
		
		//Assert
		assertEquals(sword,aMagician.getCapacity(0)); // Index 0 of capacityList
	}
	
	@Test
	public void whenMagicianIsCreated_statsAreReturned() {
		//arrange
		Stats magicianStats = new Stats(5,5,20,20);
		Capacity sword = new Sword(20);
		
		//act
		Fighter aMagician = new Magician("Max",magicianStats,sword);
		
		//Assert
		final int EXPECTED_FORCE = 5;
		final int EXPECTED_DEXTERITY = 5;
		final int EXPECTED_INTELLIGENCE = 20;
		final int EXPECTED_CONCENTRATION = 20;
		assertEquals(EXPECTED_FORCE,aMagician.getForce());
		assertEquals(EXPECTED_DEXTERITY,aMagician.getDexterity());	
		assertEquals(EXPECTED_INTELLIGENCE,aMagician.getIntelligence());	
		assertEquals(EXPECTED_CONCENTRATION,aMagician.getConcentration());	
	}
	
	@Test (expected = IllegalStatException.class)
	public void whenMagicianIsCreated_withTooMuchStats_ThenIllegalStatExceptionIsRaised() {
		//arrange
		Stats myStats = new Stats(25,25,25,26);
		Capacity sword = new Sword(20);
		//act
		new Magician("Max",myStats,sword);
	}
	
	@Test (expected = IllegalStatException.class)
	public void whenOneMagicianIsCreated_withNotEnoughForce_ThenIllegalStatExceptionIsRaised() {
		//arrange
		Stats magicianStats = new Stats(-1,5,20,19);
		Capacity sword = new Sword(20);
		//act
		new Magician("Max",magicianStats,sword);	
	}
	
	@Test (expected = IllegalStatException.class)
	public void whenOneMagicianIsCreated_withNotEnoughDexterity_ThenIllegalStatExceptionIsRaised() {
		//arrange
		Stats magicianStats = new Stats(5,-1,20,19);
		Capacity sword = new Sword(20);
		//act
		new Magician("Max",magicianStats,sword);	
	}
	
	@Test (expected = IllegalStatException.class)
	public void whenOneMagicianIsCreated_withNotEnoughIntelligence_ThenIllegalStatExceptionIsRaised() {
		//arrange
		Stats magicianStats = new Stats(11,5,25,25);
		Capacity sword = new Sword(20);
		//act
		new Magician("Max",magicianStats,sword);
	}
	
	@Test (expected = IllegalStatException.class)
	public void whenOneMagicianIsCreated_withNotEnoughConcentration_ThenIllegalStatExceptionIsRaised() {
		//arrange
		Stats magicianStats = new Stats(5,5,20,19);
		Capacity sword = new Sword(20);
		//act
		new Magician("Max",magicianStats,sword);	
	}
	
}
