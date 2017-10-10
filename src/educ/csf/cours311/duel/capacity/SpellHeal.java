package educ.csf.cours311.duel.capacity;

import edu.csf.cours311.duel.character.Stats;

public class SpellHeal extends Heal{
	
	private static Caracteristic caracteristic = Caracteristic.EFFICACITY;
	
	public SpellHeal(int caracPower){
		super(caracPower, caracteristic);
	}
	
	@Override
	public int calculatePower(Stats stats) {
		return (stats.getIntelligence() * getCaracPower() / 100);
	}
	
}
