/*
 * Class: CMSC203 
 * Instructor:
 * Description: (Give a brief description for each Class)
 * Due: MM/DD/YYYY
 * Platform/compiler:
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Christopher Newman
*/
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrderTestStudent {
	Order orderOne, orderTwo, orderThree, orderFour;
	
	@BeforeEach
	void setUp() throws Exception {
		orderOne = new Order(8, Day.MONDAY, new Customer("Mary", 22));
		orderTwo = new Order(12, Day.SATURDAY, new Customer("John", 45));
		orderThree = new Order(10, Day.SUNDAY, new Customer("Kate", 21));
	}

	@AfterEach
	void tearDown() throws Exception {
		orderOne = orderTwo = orderThree = null;
	}

	@Test
	void testIsWeekend() {
		assertFalse(orderOne.isWeekend());
		assertTrue(orderTwo.isWeekend());
		assertFalse(orderThree.isWeekend());
	}

	@Test
	void testGetBeverage() {
		Coffee cf = new Coffee("regular Coffee", Size.SMALL, false, false);
		Alcohol al = new Alcohol("Mohito", Size.SMALL, false);
		Smoothie sm1 = new Smoothie("Detox", Size.MEDIUM, 1, false);
		Smoothie sm2 = new Smoothie("Detox", Size.LARGE, 1, false);

		orderOne.addNewBeverage("regular Coffee", Size.SMALL, false, false);
		orderOne.addNewBeverage("Mohito", Size.SMALL);
		orderOne.addNewBeverage("Detox", Size.MEDIUM, 1, false);
		assertTrue(orderOne.getBeverage(0).equals(cf));
		assertTrue(orderOne.getBeverage(1).equals(al));
		assertTrue(orderOne.getBeverage(2).equals(sm1));
		assertFalse(orderOne.getBeverage(2).equals(sm2));
	}

	@Test
	void testAddNewBeverageStringSize() {
		assertTrue(orderOne.getTotalItem() == 0);
		orderOne.addNewBeverage("regular Coffee", Size.SMALL, false, false);
		assertTrue(orderOne.getBeverage(0).getType().equals(Type.COFFEE));
		orderOne.addNewBeverage("Mohito", Size.SMALL);
		assertTrue(orderOne.getBeverage(1).getType().equals(Type.ALCOHOL));
		orderOne.addNewBeverage("Detox", Size.MEDIUM, 1, false);
		assertTrue(orderOne.getBeverage(2).getType().equals(Type.SMOOTHIE));
		assertTrue(orderOne.getTotalItem() == 3);

		orderTwo.addNewBeverage("Detox", Size.MEDIUM, 4, true);
		assertTrue(orderTwo.getBeverage(0).getType().equals(Type.SMOOTHIE));
		orderTwo.addNewBeverage("Mohito", Size.SMALL);
		assertTrue(orderTwo.getBeverage(1).getType().equals(Type.ALCOHOL));
		orderTwo.addNewBeverage("regular Coffee", Size.MEDIUM, true, false);
		assertTrue(orderTwo.getBeverage(2).getType().equals(Type.COFFEE));
		assertTrue(orderTwo.getTotalItem() == 3);
	}

	@Test
	void testCalcOrderTotal() {
		orderOne.addNewBeverage("regular Coffee", Size.SMALL, false, false);
		orderOne.addNewBeverage("Mohito", Size.SMALL);
		orderOne.addNewBeverage("Detox", Size.MEDIUM, 1, false);

		assertEquals(7.5, orderOne.calcOrderTotal(), .01);

		orderTwo.addNewBeverage("regular Coffee", Size.MEDIUM, true, false);
		orderTwo.addNewBeverage("Mohito", Size.SMALL);
		orderTwo.addNewBeverage("Detox", Size.MEDIUM, 4, true);

		assertEquals(12.6, orderTwo.calcOrderTotal(), .01);
	}

	@Test
	void testFindNumOfBeveType() {
		orderOne.addNewBeverage("regular Coffee", Size.SMALL, false,false);
		orderOne.addNewBeverage("Mohito", Size.SMALL); 
		orderOne.addNewBeverage("Detox", Size.MEDIUM,1,false); 
		orderOne.addNewBeverage("French Hazelnut", Size.LARGE, true,true);
		assertEquals(2, orderOne.findNumOfBeveType(Type.COFFEE));
		assertEquals(1, orderOne.findNumOfBeveType(Type.SMOOTHIE));
		assertEquals(1, orderOne.findNumOfBeveType(Type.ALCOHOL));
		
		orderTwo.addNewBeverage("regular Coffee", Size.MEDIUM, true,false);
		orderTwo.addNewBeverage("Mohito", Size.SMALL); 
	 	assertEquals(0, orderTwo.findNumOfBeveType(Type.SMOOTHIE));
	}

	@Test
	void testToString() {
		orderOne.addNewBeverage("regular Coffee", Size.SMALL, false,false);
		orderOne.addNewBeverage("Mohito", Size.LARGE); 
		 
		assertTrue(orderOne.toString().contains( String.valueOf(orderOne.getOrderNo()) ));
		assertTrue(orderOne.toString().contains( orderOne.getCustomer().getName()) );
		assertTrue(orderOne.toString().contains(orderOne.getBeverage(0).getSize().toString()) )  ;
		assertTrue(orderOne.toString().contains(orderOne.getBeverage(0).getBevName()) );
		
	 	 
	
	}

}
