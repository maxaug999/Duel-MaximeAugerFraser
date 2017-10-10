package educ.csf.cours311.duel.capacity;

import static org.junit.Assert.*;

import org.junit.Test;

public class CapacityTest {

	@Test
	public void whenCapacityIsCreated_caracteristicIsReturned() {
		//arrange

		//act
		Sword aSword = new Sword(25);
		
		//Assert
		final int EXPECTED_CARACTERISTIC = 25;
		assertEquals(EXPECTED_CARACTERISTIC,aSword.getCaracPower());	
	}
	
	@Test (expected = IllegalCaracException.class)
	public void whenCapacityIsCreated_withTooLowCaracteristic_ThenIllegalCaracExceptionShouldRise() {
		//arrange

		//act
		new Sword(19);
		
		//Assert
	}
	
	@Test (expected = IllegalCaracException.class)
	public void whenCapacityIsCreated_withTooHighCaracteristic_ThenIllegalCaracExceptionShouldRise() {
		//arrange

		//act
		new Sword(101);
		
		//Assert
	}
}
