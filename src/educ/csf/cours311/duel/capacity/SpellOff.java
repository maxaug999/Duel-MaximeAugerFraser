package educ.csf.cours311.duel.capacity;

import edu.csf.cours311.duel.character.Stats;

public class SpellOff extends Attack{
	
	private static Caracteristic caracteristic = Caracteristic.EFFICACITY;
	
	public SpellOff(int caracPower){
		super(caracPower, caracteristic);
	}

	@Override
	public int calculatePower(Stats stats) {
		return (stats.getIntelligence() * getCaracPower() / 100)*3;
	}
	
	/*
	@Override
	public int calculatePower2(Stats stats) {
		return super.calculatePower2(stats) * 3;
	}*/
}
