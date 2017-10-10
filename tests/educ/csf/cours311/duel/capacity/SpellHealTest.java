package educ.csf.cours311.duel.capacity;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.csf.cours311.duel.character.Athlete;
import edu.csf.cours311.duel.character.Fighter;
import edu.csf.cours311.duel.character.Magician;
import edu.csf.cours311.duel.character.Stats;
import edu.csf.cours311.duel.character.Warrior;
import edu.csf.cours311.duel.simulator.DuelFactory;

public class SpellHealTest {
	
	@Test
	public void WHEN_CapacityIsCreated_THEN_caracteristicShouldBeReturned() {
		//arrange

		//act
		SpellHeal aSpellHeal = new SpellHeal(25);
		
		//Assert
		final int EXPECTED_CARACTERISTIC = 25;
		assertEquals(EXPECTED_CARACTERISTIC,aSpellHeal.getCaracPower());	
	}
	
	@Test (expected = IllegalCaracException.class)
	public void WHEN_CapacityIsCreated_withTooLowCaracteristic_THEN_IllegalCaracExceptionIsRisen() {
		//arrange

		//act
		new SpellHeal(19);
		
		//Assert
	}
	
	@Test (expected = IllegalCaracException.class)
	public void WHEN_CapacityIsCreated_withTooHighCaracteristic_THEN_IllegalCaracExceptionIsRisen() {
		//arrange

		//act
		new SpellHeal(101);
		
		//Assert
	}
	
	@Test
	public void GIVEN_aWarriorWithSpellHealCapacity_THEN_useCapacityShouldReturnPower() {
		//arrange
		Stats warriorStats = new Stats(30,20,10,5);
		Capacity aSpellOff = new SpellHeal(20);
		Fighter aWarrior = new Warrior("Max", warriorStats, aSpellOff);
		
		//act
		
		//Assert
		final int EXPECTED_POWER = 2;
		final int EXPECTED_CAPACITY_INDEX = 0;
		assertEquals(EXPECTED_POWER, aWarrior.useCapacity(EXPECTED_CAPACITY_INDEX));	
	}
	
	@Test
	public void GIVEN_aMagicianWithSpellHealCapacity_THEN_useCapacityShouldReturnPower() {
		//arrange
		Stats magicianStats = new Stats(5,5,20,20);
		Capacity aSpellHeal = new SpellHeal(20);
		Fighter aMagician = new Magician("Max", magicianStats, aSpellHeal);
		
		//act
		
		//Assert
		final int EXPECTED_POWER = 4;
		final int EXPECTED_CAPACITY_INDEX = 0;
		assertEquals(EXPECTED_POWER, aMagician.useCapacity(EXPECTED_CAPACITY_INDEX));	
	}
	
	@Test
	public void GIVEN_anAthleteWithSpellHealCapacity_THEN_useCapacityShouldReturnPower() {
		//arrange
		Stats athleteStats = new Stats(20,20,20,20);
		Capacity aSpellHeal = new SpellHeal(20);
		Fighter aAthlete = new Athlete("Max", athleteStats, aSpellHeal);
		
		//act
		
		//Assert
		final int EXPECTED_POWER = 4;
		final int EXPECTED_CAPACITY_INDEX = 0;
		assertEquals(EXPECTED_POWER, aAthlete.useCapacity(EXPECTED_CAPACITY_INDEX));	
	}
}
