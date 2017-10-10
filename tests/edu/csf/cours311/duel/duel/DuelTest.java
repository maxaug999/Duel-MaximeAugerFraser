package edu.csf.cours311.duel.duel;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.csf.cours311.duel.character.Athlete;
import edu.csf.cours311.duel.character.Fighter;
import edu.csf.cours311.duel.character.IllegalStatException;
import edu.csf.cours311.duel.character.Stats;
import edu.csf.cours311.duel.character.Warrior;
import educ.csf.cours311.duel.capacity.Capacity;
import educ.csf.cours311.duel.capacity.Caracteristic;
import educ.csf.cours311.duel.capacity.Cure;
import educ.csf.cours311.duel.capacity.Shield;
import educ.csf.cours311.duel.capacity.SpellHeal;
import educ.csf.cours311.duel.capacity.Sword;


public class DuelTest {
	
	@Test
	public void GIVEN_twoFighters_WHEN_DuelIsProvokedAndAccepted_THEN_winnerIsReturned() {
		//arrange
		Stats warriorStats = new Stats(30,20,10,10);
		Capacity sword1 = new Sword(50);
		Stats athleteStats = new Stats(20,20,20,20);
		Capacity sword2 = new Sword(20);
		Fighter aWarrior = new Warrior("Max", warriorStats, sword1);
		Fighter anAthlete = new Athlete("Carl", athleteStats,sword2);
		
		//act
		Duel duel = new Duel(aWarrior, anAthlete); // Challenger / Defender
		duel.provokeDuel(0);
		duel.acceptDuel(0);
		
		//Assert
		Fighter EXPECTED_WINNER = aWarrior;
		assertEquals(EXPECTED_WINNER,duel.getWinner());
	}
	
	@Test
	public void GIVEN_twoFighters_WHEN_DuelIsProvokedAndAccepted_THEN_loserIsReturned() {
		//arrange
		Stats warriorStats = new Stats(30,20,10,10);
		Capacity sword1 = new Sword(50);
		Stats athleteStats = new Stats(20,20,20,20);
		Capacity sword2 = new Sword(20);
		Fighter aWarrior = new Warrior("Max", warriorStats, sword1);
		Fighter anAthlete = new Athlete("Carl", athleteStats,sword2);
		
		//act
		Duel duel = new Duel(aWarrior, anAthlete);
		duel.provokeDuel(0);
		duel.acceptDuel(0);
		
		//Assert
		Fighter EXPECTED_LOSER = anAthlete;
		assertEquals(EXPECTED_LOSER,duel.getLoser());
	}
	
	@Test
	public void GIVEN_twoFightersAndDuel_WHEN_duelEnds_AllWinnerStatsShoudlIncrementByOne() {
		//arrange
		Stats warriorStats = new Stats(30,20,10,10);
		Capacity sword1 = new Sword(50);
		Stats athleteStats = new Stats(20,20,20,20);
		Capacity sword2 = new Sword(20);
		Fighter aWarrior = new Warrior("Max", warriorStats, sword1);
		Fighter anAthlete = new Athlete("Carl", athleteStats,sword2);
		Duel duel = new Duel(aWarrior, anAthlete);
		
		//Act
		Capacity shield = new Shield(20);
		duel.provokeDuel(0);
		duel.acceptDuel(0);
		duel.endDuel(shield);
		
		//Assert
		final int EXPECTED_FORCE = 31;
		final int EXPECTED_DEXTERITY = 21;
		final int EXPECTED_INTELLIGENCE = 11;
		final int EXPECTED_CONCENTRATION = 11;
		assertEquals(EXPECTED_FORCE,aWarrior.getForce());
		assertEquals(EXPECTED_DEXTERITY,aWarrior.getDexterity());	
		assertEquals(EXPECTED_INTELLIGENCE,aWarrior.getIntelligence());	
		assertEquals(EXPECTED_CONCENTRATION,aWarrior.getConcentration());	
	}
	
	@Test
	public void GIVEN_twoFightersAndDuel_WHEN_duelEnds_THEN_LoserAllStatsShoudlDecreaseByOne() {
		//arrange
		Stats warriorStats = new Stats(30,20,10,10);
		Capacity sword1 = new Sword(20);
		Stats athleteStats = new Stats(20,20,20,20);
		Capacity sword2 = new Sword(50);
		Fighter aWarrior = new Warrior("Max", warriorStats, sword1);
		Fighter anAthlete = new Athlete("Carl", athleteStats,sword2);
		Duel duel = new Duel(aWarrior, anAthlete);
		
		//Act
		Capacity shield = new Shield(20);
		duel.provokeDuel(0);
		duel.acceptDuel(0);
		duel.endDuel(shield);
		
		//Assert
		final int EXPECTED_FORCE = 29;
		final int EXPECTED_DEXTERITY = 19;
		final int EXPECTED_INTELLIGENCE = 9;
		final int EXPECTED_CONCENTRATION = 9;
		assertEquals(EXPECTED_FORCE,aWarrior.getForce());
		assertEquals(EXPECTED_DEXTERITY,aWarrior.getDexterity());	
		assertEquals(EXPECTED_INTELLIGENCE,aWarrior.getIntelligence());	
		assertEquals(EXPECTED_CONCENTRATION,aWarrior.getConcentration());	
	}
	
	@Test
	public void GIVEN_twoFighters_WHEN_duelIsCreatedAndDefenderSurrenders_THEN_ChallengerShouldBeTheWinner() {
		//arrange
		Stats warriorStats = new Stats(30,20,10,10);
		Capacity sword1 = new Sword(20);
		Stats athleteStats = new Stats(20,20,20,20);
		Capacity sword2 = new Sword(50);
		Fighter aWarrior = new Warrior("Max", warriorStats, sword1);
		Fighter anAthlete = new Athlete("Carl", athleteStats,sword2);
		Duel duel = new Duel(aWarrior, anAthlete);
		
		//Act
		duel.surrender();
		
		//Assert
		assertEquals(aWarrior,duel.getWinner());	
	}
	
	@Test
	public void GIVEN_twoFightersAndDuel_WHEN_whenChallengerLosesDuel_THEN_ChallengerShouldLosesHP() {
		//arrange
		Stats warriorStats = new Stats(30,20,10,10);
		Capacity sword1 = new Sword(20);
		Stats athleteStats = new Stats(20,20,20,20);
		Capacity sword2 = new Sword(100);
		Fighter aWarrior = new Warrior("Max", warriorStats, sword1);
		Fighter anAthlete = new Athlete("Carl", athleteStats,sword2);
		Duel duel = new Duel(aWarrior, anAthlete);
		
		//Act
		duel.provokeDuel(0);
		duel.acceptDuel(0);
		
		//Assert
		final int EXPECTED_HP = 116;
		assertEquals(EXPECTED_HP, aWarrior.getHp());
	}
	
	@Test
	public void GIVEN_twoFightersAndDuel_WHEN_whenDefenderLosesDuel_THEN_DefenderShouldLosesHP() {
		//arrange
		Stats warriorStats = new Stats(30,20,10,10);
		Capacity sword1 = new Sword(100);
		Stats athleteStats = new Stats(20,20,20,20);
		Capacity sword2 = new Sword(20);
		Fighter aWarrior = new Warrior("Max", warriorStats, sword1);
		Fighter anAthlete = new Athlete("Carl", athleteStats,sword2);
		Duel duel = new Duel(aWarrior, anAthlete);
		
		//Act
		duel.provokeDuel(0);
		duel.acceptDuel(0);
		
		//Assert
		final int EXPECTED_HP = 94;
		assertEquals(EXPECTED_HP, anAthlete.getHp());
	}
	
	@Test
	public void GIVEN_twoFighters_WHEN_duelIsCreatedAndDefenderSurrenders_THEN_DefenderShouldBeTheLoser() {
		//arrange
		Stats warriorStats = new Stats(30,20,10,10);
		Capacity sword1 = new Sword(20);
		Stats athleteStats = new Stats(20,20,20,20);
		Capacity sword2 = new Sword(50);
		Fighter aWarrior = new Warrior("Max", warriorStats, sword1);
		Fighter anAthlete = new Athlete("Carl", athleteStats,sword2);
		
		//Act
		Duel duel = new Duel(aWarrior, anAthlete);
		duel.surrender();
		
		//Assert
		assertEquals(anAthlete,duel.getLoser());	
	}

	@Test	(expected = IllegalIndexCapacityListException.class)
	public void WHEN_indexOfCapacityInProvokeDuelIsTooHigh_THEN_shouldRiseIllegalIndexCapacityListException() {
		//arrange
		Stats warriorStats = new Stats(30,20,10,10);
		Capacity sword1 = new Sword(20);
		Stats athleteStats = new Stats(20,20,20,20);
		Capacity sword2 = new Sword(50);
		Fighter aWarrior = new Warrior("Max", warriorStats, sword1);
		Fighter anAthlete = new Athlete("Carl", athleteStats,sword2);
		Duel duel = new Duel(aWarrior, anAthlete);
		
		//Act
		duel.provokeDuel(10);	
	}
	
	@Test	(expected = IllegalIndexCapacityListException.class)
	public void WHEN_indexOfCapacityInProvokeDuelIsTooLow_THEN_shouldRiseIllegalIndexCapacityListException() {
		//arrange
		Stats warriorStats = new Stats(30,20,10,10);
		Capacity sword1 = new Sword(20);
		Stats athleteStats = new Stats(20,20,20,20);
		Capacity sword2 = new Sword(50);
		Fighter aWarrior = new Warrior("Max", warriorStats, sword1);
		Fighter anAthlete = new Athlete("Carl", athleteStats,sword2);
		Duel duel = new Duel(aWarrior, anAthlete);
		
		//Act
		duel.provokeDuel(-1);	
	}

	@Test	(expected = IllegalIndexCapacityListException.class)
	public void WHEN_indexOfCapacityInAcceptDuelIsTooHigh_THEN_shouldRiseIllegalIndexCapacityListException() {
		//arrange
		Stats warriorStats = new Stats(30,20,10,10);
		Capacity sword1 = new Sword(20);
		Stats athleteStats = new Stats(20,20,20,20);
		Capacity sword2 = new Sword(50);
		Fighter aWarrior = new Warrior("Max", warriorStats, sword1);
		Fighter anAthlete = new Athlete("Carl", athleteStats,sword2);
		Duel duel = new Duel(aWarrior, anAthlete);
		
		//Act
		duel.provokeDuel(10);	
	}
	
	@Test	(expected = IllegalIndexCapacityListException.class)
	public void WHEN_indexOfCapacityInAcceptDuelIsTooLow_THEN_shouldRiseIllegalIndexCapacityListException() {
		//arrange
		Stats warriorStats = new Stats(30,20,10,10);
		Capacity sword1 = new Sword(20);
		Stats athleteStats = new Stats(20,20,20,20);
		Capacity sword2 = new Sword(50);
		Fighter aWarrior = new Warrior("Max", warriorStats, sword1);
		Fighter anAthlete = new Athlete("Carl", athleteStats,sword2);
		Duel duel = new Duel(aWarrior, anAthlete);
		
		//Act
		duel.provokeDuel(-1);	
	}
	
	@Test
	public void GIVEN_twoFightersAndDuel_WHEN_duelEnds_THEN_WinnerShouldHaveOneMoreCapacity() {
		//arrange
		Stats warriorStats = new Stats(30,20,10,10);
		Capacity sword1 = new Sword(20);
		Stats athleteStats = new Stats(20,20,20,20);
		Capacity sword2 = new Sword(50);
		Fighter aWarrior = new Warrior("Max", warriorStats, sword1);
		Fighter anAthlete = new Athlete("Carl", athleteStats,sword2);
		Duel duel = new Duel(aWarrior, anAthlete);
		
		//Act
		Capacity shield = new Shield(20);
		duel.provokeDuel(0);
		duel.acceptDuel(0);
		duel.endDuel(shield);
		
		//Assert
		final int EXPECTED_CAPACITY_INDEX = 1;
		assertEquals(shield,anAthlete.getCapacity(EXPECTED_CAPACITY_INDEX));	
	}
	
	@Test (expected = IllegalCapacityForDuelException.class)
	public void GIVEN_twoFightersAndDuel_WHEN_challengerIsProvokingWithCureCapacity_THEN_IllegalCapacityForDuelIsRisen() {
		//arrange
		Stats warriorStats = new Stats(30,20,10,10);
		Capacity cure = new Cure(20);
		Stats athleteStats = new Stats(20,20,20,20);
		Capacity sword = new Sword(50);
		Fighter aWarrior = new Warrior("Max", warriorStats, cure);
		Fighter anAthlete = new Athlete("Carl", athleteStats,sword);
		Duel duel = new Duel(aWarrior, anAthlete);
		
		//Act
		duel.provokeDuel(0);
	}
	
	@Test (expected = IllegalCapacityForDuelException.class)
	public void GIVEN_twoFightersAndDuel_WHEN_challengerIsProvokingWithSpellHealCapacity_THEN_IllegalCapacityForDuelIsRisen() {
		//arrange
		Stats warriorStats = new Stats(30,20,10,10);
		Capacity cure = new SpellHeal(20);
		Stats athleteStats = new Stats(20,20,20,20);
		Capacity sword = new Sword(50);
		Fighter aWarrior = new Warrior("Max", warriorStats, cure);
		Fighter anAthlete = new Athlete("Carl", athleteStats,sword);
		Duel duel = new Duel(aWarrior, anAthlete);
		
		//Act
		duel.provokeDuel(0);
	}
	
	@Test (expected = IllegalCapacityForDuelException.class)
	public void GIVEN_twoFightersAndDuel_WHEN_defenderIsAcceptingDuelWithSpellHealCapacity_THEN_IllegalCapacityForDuelIsRisen() {
		//arrange
		Stats warriorStats = new Stats(30,20,10,10);
		Capacity sword = new Sword(20);
		Stats athleteStats = new Stats(20,20,20,20);
		Capacity spellHeal = new SpellHeal(50);
		Fighter aWarrior = new Warrior("Max", warriorStats, sword);
		Fighter anAthlete = new Athlete("Carl", athleteStats, spellHeal);
		Duel duel = new Duel(aWarrior, anAthlete);
		
		//Act
		duel.provokeDuel(0);
		duel.acceptDuel(0);
	}
	
	@Test (expected = IllegalCapacityForDuelException.class)
	public void GIVEN_twoFightersAndDuel_WHEN_defenderIsAcceptingDuelWithCureCapacity_THEN_IllegalCapacityForDuelIsRisen() {
		//arrange
		Stats warriorStats = new Stats(30,20,10,10);
		Capacity sword = new Sword(20);
		Stats athleteStats = new Stats(20,20,20,20);
		Capacity cure = new Cure(50);
		Fighter aWarrior = new Warrior("Max", warriorStats, sword);
		Fighter anAthlete = new Athlete("Carl", athleteStats, cure);
		Duel duel = new Duel(aWarrior, anAthlete);
		
		//Act
		duel.provokeDuel(0);
		duel.acceptDuel(0);
	}
}
