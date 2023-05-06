import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AlcoholTest {
	Alcohol a1, a2, a3;
	@BeforeEach
	void setUp() throws Exception {
		a1 = new Alcohol("John", Size.SMALL, false);
		a2 = new Alcohol("Chris", Size.MEDIUM, true);
		a3 = new Alcohol("Bod", Size.LARGE, false);
	}

	@AfterEach
	void tearDown() throws Exception {
		a1 = a2 = a3 = null;
	}

	@Test
	void testCalcPrice() {
		assertEquals(2, a1.calcPrice(), .01);
		assertEquals(3.6, a2.calcPrice(), .01);
		assertEquals(4, a3.calcPrice(), .01);
	}

	@Test
	void testToString() {
		assertTrue(a1.toString().contains(a1.getBevName()));
		assertTrue(a1.toString().contains(String.valueOf(a1.calcPrice())) );
		assertTrue(a1.toString().contains(a1.getSize().toString()));
	}

	
}
