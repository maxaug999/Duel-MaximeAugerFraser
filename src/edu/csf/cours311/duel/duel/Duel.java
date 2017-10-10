package edu.csf.cours311.duel.duel;

import edu.csf.cours311.duel.character.Fighter;
import educ.csf.cours311.duel.capacity.Capacity;
import educ.csf.cours311.duel.capacity.Cure;
import educ.csf.cours311.duel.capacity.SpellHeal;

public class Duel {
	
	private Fighter winner;
	private Fighter loser;
	
	Fighter challenger; // Provocateur
	Fighter defender;  
	int challengerIndexCapacity;
	int defenderIndexCapacity;
	
	public Duel(Fighter fighter1, Fighter fighter2){
		this.challenger = fighter1;
		this.defender = fighter2;
	}
	
	private void validateIndexOfCapacityList(int capacityIndex) {
		if(capacityIndex > challenger.getArrayListCapacity().size()) {
			throw new IllegalIndexCapacityListException();
		}
		if(capacityIndex < 0) {
			throw new IllegalIndexCapacityListException();
		}
	}
	
	public void provokeDuel(int capacityIndex) {
		validateIndexOfCapacityList(capacityIndex);
		validateChallengerCapacity(capacityIndex);
		this.challengerIndexCapacity = capacityIndex;
	}
	private void validateChallengerCapacity(int capacityIndex) {
		if(this.challenger.getCapacity(capacityIndex).getClass() == Cure.class) {
			throw new IllegalCapacityForDuelException();
		}
		if(this.challenger.getCapacity(capacityIndex).getClass() == SpellHeal.class) {
			throw new IllegalCapacityForDuelException();
		}
	}
	
	private void validateDefenderCapacity(int capacityIndex) {
		if(this.defender.getCapacity(capacityIndex).getClass() == Cure.class) {
			throw new IllegalCapacityForDuelException();
		}
		if(this.defender.getCapacity(capacityIndex).getClass() == SpellHeal.class) {
			throw new IllegalCapacityForDuelException();
		}
	}
	
	public void acceptDuel(int capacityIndex) {
		validateIndexOfCapacityList(capacityIndex);
		validateDefenderCapacity(capacityIndex);
		this.defenderIndexCapacity = capacityIndex;
		duelFight();
	}
	
	private void duelFight() {
		int powerChallenger = challenger.useCapacity(challengerIndexCapacity);
		int powerDefender = defender.useCapacity(defenderIndexCapacity);
		int damage; // power difference
		
		if(powerChallenger > powerDefender) {
			damage = powerChallenger - powerDefender;
			attackEnemy(damage, defender);
			this.winner = challenger;
			this.loser = defender;
		}else {
			if(powerDefender > powerChallenger) {
				damage = powerDefender - powerChallenger;
				attackEnemy(damage, challenger);
				this.winner = defender;
				this.loser = challenger;
			}else {
				this.winner = challenger;
				this.loser = defender;
			}
		}
	}
	
	private void attackEnemy(int damage, Fighter fighterEnemy) {
		fighterEnemy.setHp(fighterEnemy.getHp() - damage);
	}
	
	public void surrender() {
		this.winner = challenger;
		this.loser = defender;
	}
	
	public void endDuel(Capacity capacity) {
		this.winner.addCapacity(capacity);
		this.winner.getStats().incrementsStats();
		this.loser.getStats().decreaseStats();
	}
	
	public Fighter getWinner() {
		return this.winner;
	}
	
	public Fighter getLoser() {
		return this.loser;
	}
}
