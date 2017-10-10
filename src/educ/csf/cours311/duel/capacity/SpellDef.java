package educ.csf.cours311.duel.capacity;

import edu.csf.cours311.duel.character.Stats;

public class SpellDef extends Parry{
	
	private static Caracteristic caracteristic = Caracteristic.EFFICACITY;
	
	public SpellDef(int caracPower){
		super(caracPower, caracteristic);
	}
	
	@Override
	public int calculatePower(Stats stats) {
		return (stats.getIntelligence() * getCaracPower() / 100)*3;
	}
	
}
