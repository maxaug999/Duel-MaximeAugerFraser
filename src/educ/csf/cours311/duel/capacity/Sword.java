package educ.csf.cours311.duel.capacity;

import edu.csf.cours311.duel.character.Stats;

public class Sword extends Attack{
	
	private static Caracteristic caracteristic = Caracteristic.IMPACT;
	
	public Sword(int caracPower){
		super(caracPower, caracteristic);
	}
	
	@Override
	public int calculatePower(Stats stats) {
		return (stats.getForce() * getCaracPower() / 100);
	}
	
}
