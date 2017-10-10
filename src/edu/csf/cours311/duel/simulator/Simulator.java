package edu.csf.cours311.duel.simulator;

import java.util.ArrayList;

import edu.csf.cours311.duel.character.Fighter;
import edu.csf.cours311.duel.character.Stats;
import educ.csf.cours311.duel.capacity.Capacity;

public class Simulator {
	
	public static void main(String[] args) {
		ArrayList<Fighter> fighterList = new ArrayList<Fighter>();
		DuelFactory facto = new DuelFactory();
		
		//Challenger
		Capacity sword = facto.createCapacity("Sword", 20);
		Stats challengerStats  = facto.createStats(30, 20, 10, 10);
		Fighter challenger = facto.createFighter("Warrior", "Max", challengerStats, sword);
		fighterList.add(challenger);
		
		//Defender
		Capacity Cure = facto.createCapacity("Sword", 20);
		Stats defenderStats  = facto.createStats(30, 20, 10, 10);
		Fighter defender = facto.createFighter("Warrior", "Max", defenderStats, sword);
		fighterList.add(defender);
	}
}
