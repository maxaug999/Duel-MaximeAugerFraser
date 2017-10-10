package educ.csf.cours311.duel.capacity;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.csf.cours311.duel.character.Athlete;
import edu.csf.cours311.duel.character.Fighter;
import edu.csf.cours311.duel.character.Magician;
import edu.csf.cours311.duel.character.Stats;
import edu.csf.cours311.duel.character.Warrior;
import edu.csf.cours311.duel.simulator.DuelFactory;

public class ShieldTest {
	
	@Test
	public void WHEN_CapacityIsCreated_THEN_caracteristicShouldBeReturned() {
		//arrange

		//act
		Shield aShield = new Shield(25);
		
		//Assert
		final int EXPECTED_CARACTERISTIC = 25;
		assertEquals(EXPECTED_CARACTERISTIC,aShield.getCaracPower());	
	}
	
	@Test (expected = IllegalCaracException.class)
	public void WHEN_CapacityIsCreated_withTooLowCaracteristic_THEN_IllegalCaracExceptionIsRisen() {
		//arrange

		//act
		new Shield(19);
		
		//Assert
	}
	
	@Test (expected = IllegalCaracException.class)
	public void WHEN_CapacityIsCreated_withTooHighCaracteristic_THEN_IllegalCaracExceptionIsRisen() {
		//arrange

		//act
		new Shield(101);
		
		//Assert
	}
	
	@Test
	public void GIVEN_aWarriorWithShieldCapacity_THEN_useCapacityShouldReturnPower() {
		//arrange
		Stats warriorStats = new Stats(30,20,10,5);
		Capacity aShield = new Shield(20);
		Fighter aWarrior = new Warrior("Max", warriorStats, aShield);
		
		//act
		
		//Assert
		final int EXPECTED_POWER = 6;
		final int EXPECTED_CAPACITY_INDEX = 0;
		assertEquals(EXPECTED_POWER, aWarrior.useCapacity(EXPECTED_CAPACITY_INDEX));	
	}
	
	@Test
	public void GIVEN_aMagicianWithShieldCapacity_THEN_useCapacityShouldReturnPower() {
		//arrange
		Stats magicianStats = new Stats(5,5,20,20);
		Capacity aShield = new Shield(20);
		Fighter aMagician = new Magician("Max", magicianStats, aShield);
		
		//act
		
		//Assert
		final int EXPECTED_POWER = 1;
		final int EXPECTED_CAPACITY_INDEX = 0;
		assertEquals(EXPECTED_POWER, aMagician.useCapacity(EXPECTED_CAPACITY_INDEX));	
	}
	
	@Test
	public void GIVEN_anAthleteWithShieldCapacity_THEN_useCapacityShouldReturnPower() {
		//arrange
		Stats athleteStats = new Stats(20,20,20,20);
		Capacity aShield = new Shield(20);
		Fighter aAthlete = new Athlete("Max", athleteStats, aShield);
		
		//act
		
		//Assert
		final int EXPECTED_POWER = 4;
		final int EXPECTED_CAPACITY_INDEX = 0;
		assertEquals(EXPECTED_POWER, aAthlete.useCapacity(EXPECTED_CAPACITY_INDEX));	
	}
}
