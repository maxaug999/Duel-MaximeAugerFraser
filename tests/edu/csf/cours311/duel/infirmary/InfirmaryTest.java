package edu.csf.cours311.duel.infirmary;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.csf.cours311.duel.character.Fighter;
import edu.csf.cours311.duel.character.Stats;
import edu.csf.cours311.duel.character.Warrior;
import edu.csf.cours311.duel.duel.IllegalIndexCapacityListException;
import educ.csf.cours311.duel.capacity.Capacity;
import educ.csf.cours311.duel.capacity.Cure;
import educ.csf.cours311.duel.capacity.SpellHeal;
import educ.csf.cours311.duel.capacity.Sword;

public class InfirmaryTest {
	
	@Test
	public void  GIVEN_aWarrior_WHEN_GetsNewCureCapacityAndGoesToInfirmary_THEN_WarriorReceivesAdditionalHp() {
		//arrange
		Stats warriorStats = new Stats(30,20,10,10);
		Capacity sword = new Sword(20);
		Fighter aWarrior = new Warrior("Max", warriorStats, sword); // 130 HP
		
		//act
		Capacity cure = new Cure(20);
		aWarrior.addCapacity(cure);
		final int EXPECTED_INDEX_FOR_CURE_CAPACITY = 1;
		Infirmary infirmary = new Infirmary(aWarrior);
		infirmary.heal(EXPECTED_INDEX_FOR_CURE_CAPACITY); // 20Dex*20Carac/100
		
		//assert
		final int EXPECTED_HP = 134;
		assertEquals(EXPECTED_HP, aWarrior.getHp()); 
	}
	
	@Test
	public void  WHEN_aFighterGetsNewSpellHealCapacityAndGoesToInfirmary_THEN_fighterReceivesAdditionalHp() {
		//arrange
		Stats warriorStats = new Stats(30,20,10,10);
		Capacity sword = new Sword(20);
		Fighter aWarrior = new Warrior("Max", warriorStats, sword); // 130 HP
		
		//act
		Capacity spellHeal = new SpellHeal(20);
		aWarrior.addCapacity(spellHeal);
		final int EXPECTED_INDEX_FOR_CURE_CAPACITY = 1;
		Infirmary infirmary = new Infirmary(aWarrior);
		infirmary.heal(EXPECTED_INDEX_FOR_CURE_CAPACITY); // 10Int*20Carac/100
		
		//assert
		final int EXPECTED_HP = 132;
		assertEquals(EXPECTED_HP, aWarrior.getHp()); 
	}
	
	@Test (expected = IllegalCapacityForInfirmaryException.class)
	public void  WHEN_aFighterWithNoHealingCapacityUsesHealInInfirmary_THEN_IllegalCapacityForInfirmaryExceptionIsRisen() {
		//arrange
		Stats warriorStats = new Stats(30,20,10,10);
		Capacity sword = new Sword(20);
		Fighter aWarrior = new Warrior("Max", warriorStats, sword);
		
		//act
		Infirmary infirmary = new Infirmary(aWarrior);
		infirmary.heal(0);
	}
	
	@Test (expected = IllegalIndexCapacityListException.class)
	public void  WHEN_aFighterUsesHealInInfirmaryWithATooHighIndex_THEN_IllegalIndexCapacityListExceptionIsRisen() {
		//arrange
		Stats warriorStats = new Stats(30,20,10,10);
		Capacity cure = new Cure(20);
		Fighter aWarrior = new Warrior("Max", warriorStats, cure);
		
		//act
		Infirmary infirmary = new Infirmary(aWarrior);
		infirmary.heal(10);
	}
	
	@Test (expected = IllegalIndexCapacityListException.class)
	public void  WHEN_aFighterUsesHealInInfirmaryWithATooLowIndex_THEN_IllegalIndexCapacityListExceptionIsRisen() {
		//arrange
		Stats warriorStats = new Stats(30,20,10,10);
		Capacity cure = new Cure(20);
		Fighter aWarrior = new Warrior("Max", warriorStats, cure);
		
		//act
		Infirmary infirmary = new Infirmary(aWarrior);
		infirmary.heal(-10);
	}
	
	@Test (expected = IndexOutOfBoundsException.class)
	public void  WHEN_aFighterUsesHealInInfirmaryAndLosesAllCapacities_THEN_IndexOutOfBoundsExceptionIsRisen() {
		//arrange
		Stats warriorStats = new Stats(30,20,10,10);
		Capacity cure = new Cure(20);
		Fighter aWarrior = new Warrior("Max", warriorStats, cure);
		
		//act
		Infirmary infirmary = new Infirmary(aWarrior);
		infirmary.heal(0);
		infirmary.heal(0);
	}
}
