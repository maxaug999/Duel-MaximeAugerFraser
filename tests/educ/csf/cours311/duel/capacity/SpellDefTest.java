package educ.csf.cours311.duel.capacity;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.csf.cours311.duel.character.Athlete;
import edu.csf.cours311.duel.character.Fighter;
import edu.csf.cours311.duel.character.Magician;
import edu.csf.cours311.duel.character.Stats;
import edu.csf.cours311.duel.character.Warrior;
import edu.csf.cours311.duel.simulator.DuelFactory;

public class SpellDefTest {
	
	@Test
	public void WHEN_CapacityIsCreated_THEN_caracteristicShouldBeReturned() {
		//arrange

		//act
		SpellDef aSpellDef = new SpellDef(25);
		
		//Assert
		final int EXPECTED_CARACTERISTIC = 25;
		assertEquals(EXPECTED_CARACTERISTIC,aSpellDef.getCaracPower());	
	}
	
	@Test (expected = IllegalCaracException.class)
	public void WHEN_CapacityIsCreated_withTooLowCaracteristic_THEN_IllegalCaracExceptionIsRisen() {
		//arrange

		//act
		new SpellDef(19);
		
		//Assert
	}
	
	@Test (expected = IllegalCaracException.class)
	public void WHEN_CapacityIsCreated_withTooHighCaracteristic_THEN_IllegalCaracExceptionIsRisen() {
		//arrange

		//act
		new SpellDef(101);
		
		//Assert
	}
	
	@Test
	public void GIVEN_aWarriorWithSpellDefCapacity_THEN_useCapacityShouldReturnPower() {
		//arrange
		Stats warriorStats = new Stats(30,20,10,5);
		Capacity aSpellDef = new SpellDef(20);
		Fighter aWarrior = new Warrior("Max", warriorStats, aSpellDef);
		
		//act
		
		//Assert
		final int EXPECTED_POWER = 6;
		final int EXPECTED_CAPACITY_INDEX = 0;
		assertEquals(EXPECTED_POWER, aWarrior.useCapacity(EXPECTED_CAPACITY_INDEX));	
	}
	
	@Test
	public void GIVEN_aMagicianWithSpellDefCapacity_THEN_useCapacityShouldReturnPower() {
		//arrange
		Stats magicianStats = new Stats(5,5,20,20);
		Capacity aSpellDef = new SpellDef(20);
		Fighter aMagician = new Magician("Max", magicianStats, aSpellDef);
		
		//act
		
		//Assert
		final int EXPECTED_POWER = 12;
		final int EXPECTED_CAPACITY_INDEX = 0;
		assertEquals(EXPECTED_POWER, aMagician.useCapacity(EXPECTED_CAPACITY_INDEX));	
	}
	
	@Test
	public void GIVEN_anAthleteWithSpellDefCapacity_THEN_useCapacityShouldReturnPower() {
		//arrange
		Stats athleteStats = new Stats(20,20,20,20);
		Capacity aSpellDef = new SpellDef(20);
		Fighter aAthlete = new Athlete("Max", athleteStats, aSpellDef);
		
		//act
		
		//Assert
		final int EXPECTED_POWER = 12;
		final int EXPECTED_CAPACITY_INDEX = 0;
		assertEquals(EXPECTED_POWER, aAthlete.useCapacity(EXPECTED_CAPACITY_INDEX));	
	}
}
