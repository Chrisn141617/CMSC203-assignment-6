import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CoffeeTest {
	
	Coffee c1, c2, c3;

	@BeforeEach
	void setUp() throws Exception {
		c1 = new  Coffee ("John", Size.SMALL, false,false );
		c2 = new  Coffee ("Chris", Size.MEDIUM, true,true );
		c3 = new  Coffee ("Bad", Size.LARGE, false, true );
	}

	@AfterEach
	void tearDown() throws Exception {
		c1 = c2 = c3 = null;
	}

	@Test
	void testCalcPrice() {
		assertEquals(2, c1.calcPrice(), .01 );
		assertEquals(4, c2.calcPrice(), .01 );
		assertEquals(4.5, c3.calcPrice(), .01 );
	}

	@Test
	void testToString() {
		assertTrue(c1.toString().contains(c1.getBevName()));
		assertTrue(c1.toString().contains(String.valueOf(c1.calcPrice()) ));
		assertTrue(c1.toString().contains(c1.getSize().toString() ));
	}

}
