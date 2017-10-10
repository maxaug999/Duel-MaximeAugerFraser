package educ.csf.cours311.duel.capacity;

import edu.csf.cours311.duel.character.Stats;

public class Shield extends Parry{
	
	private static Caracteristic caracteristic = Caracteristic.PROTECTION;
	
	public Shield(int caracPower){
		super(caracPower, caracteristic);
	}
	
	@Override
	public int calculatePower(Stats stats) {
		return (stats.getForce() * getCaracPower() / 100);
	}
	
}
