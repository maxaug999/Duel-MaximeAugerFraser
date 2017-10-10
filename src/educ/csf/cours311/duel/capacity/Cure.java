package educ.csf.cours311.duel.capacity;

import edu.csf.cours311.duel.character.Stats;

public class Cure extends Heal{
	
	private static Caracteristic caracteristic = Caracteristic.EFFICACITY;
	
	public Cure(int caracPower){
		super(caracPower, caracteristic);
	}
	
	@Override
	public int calculatePower(Stats stats) {
		return (stats.getDexterity() * getCaracPower() / 100);
	}
	
}
