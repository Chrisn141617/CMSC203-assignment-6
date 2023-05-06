import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BevShopTestStudent {
	BevShop bevShop;

	@BeforeEach
	void setUp() throws Exception {
		bevShop = new BevShop();
	}

	@AfterEach
	void tearDown() throws Exception {
		bevShop = null;
	}

	@Test
	void testIsValidTime() {
		assertTrue(bevShop.isValidTime(8));
		assertFalse(bevShop.isValidTime(7));
	}

	@Test
	void testIsValidAge() {
		assertTrue(bevShop.isValidAge(27));
		assertFalse(bevShop.isValidAge(20));
	}

	@Test
	void testStartNewOrder() {
		bevShop.startNewOrder(8, Day.TUESDAY, "Chris", 30);
		assertEquals(8, bevShop.getCurrentOrder().getOrderTime());
		assertEquals(Day.TUESDAY, bevShop.getCurrentOrder().getOrderDay());
		assertEquals(8, bevShop.getCurrentOrder().getOrderTime());
		assertEquals("Chris", bevShop.getCurrentOrder().getCustomer().getName());
		assertEquals(30, bevShop.getCurrentOrder().getCustomer().getAge());
		assertEquals(0, bevShop.getNumOfAlcoholDrink());
		assertTrue(bevShop.getCurrentOrder().getTotalItem() == 0);
	}

	@Test
	void testProcessCoffeeOrder() {
		
	}

	@Test
	void testProcessAlcoholOrder() {
			bevShop.startNewOrder(8,Day.MONDAY,"Mohito", 30);
		
		bevShop.processAlcoholOrder("Mohito", Size.LARGE);
		assertTrue(bevShop.getCurrentOrder().getTotalItem() == 1);
		assertTrue(bevShop.getCurrentOrder().getBeverage(0).getBevName().equals("Mohito"));
		assertTrue(bevShop.getCurrentOrder().getBeverage(0).getSize().equals(Size.LARGE));
		assertTrue(bevShop.getCurrentOrder().getBeverage(0).getType().equals(Type.ALCOHOL));	
		assertTrue(bevShop.isEligibleForMore());
		bevShop.processAlcoholOrder("tonic", Size.MEDIUM);
		assertTrue(bevShop.getCurrentOrder().getTotalItem() == 2);
		assertTrue(bevShop.getCurrentOrder().getBeverage(1).getBevName().equals("tonic"));
		assertTrue(bevShop.getCurrentOrder().getBeverage(1).getSize().equals(Size.MEDIUM));
		assertTrue(bevShop.getCurrentOrder().getBeverage(1).getType().equals(Type.ALCOHOL));	
		assertTrue(bevShop.isEligibleForMore());
		bevShop.processAlcoholOrder("V", Size.SMALL);
		assertTrue(bevShop.getCurrentOrder().getTotalItem() == 3);
		assertTrue(bevShop.getCurrentOrder().getBeverage(2).getBevName().equals("V"));
		assertTrue(bevShop.getCurrentOrder().getBeverage(2).getSize().equals(Size.SMALL));
		assertTrue(bevShop.getCurrentOrder().getBeverage(2).getType().equals(Type.ALCOHOL));	
		assertEquals(1,bevShop.totalNumOfMonthlyOrders());
	}

	@Test
	void testProcessSmoothieOrder() 
	{
		bevShop.startNewOrder(8,Day.MONDAY,"John", 30);
		assertTrue ( bevShop.isMaxFruit(6) );
		assertFalse ( bevShop.isMaxFruit(5) );
		bevShop.processSmoothieOrder("Detox", Size.SMALL, 1, false);
		assertTrue(bevShop.getCurrentOrder().getTotalItem() == 1);
		
		Smoothie sm = (Smoothie) bevShop.getCurrentOrder().getBeverage(0);
		
		assertTrue(bevShop.getCurrentOrder().getBeverage(0).getBevName().equals("Detox"));
		assertTrue(bevShop.getCurrentOrder().getBeverage(0).getSize().equals(Size.SMALL));
		assertTrue(bevShop.getCurrentOrder().getBeverage(0).getType().equals(Type.SMOOTHIE));
		
		
		assertTrue(sm.getNumOfFruits() == 1);
		assertFalse(sm.getAddProtein());
		 
		
		bevShop.processSmoothieOrder("Morning SunShine", Size.LARGE, 4, true);
		assertTrue(bevShop.getCurrentOrder().getTotalItem() == 2);
		
		sm =  (Smoothie) bevShop.getCurrentOrder().getBeverage(1);
		assertTrue(bevShop.getCurrentOrder().getBeverage(1).getBevName().equals("Morning SunShine"));
		assertTrue(bevShop.getCurrentOrder().getBeverage(1).getSize().equals(Size.LARGE));
		assertTrue(bevShop.getCurrentOrder().getBeverage(1).getType().equals(Type.SMOOTHIE));
		
		assertTrue(sm.getNumOfFruits() == 4);
		assertTrue(sm.getAddProtein());
		assertEquals(1,bevShop.totalNumOfMonthlyOrders());
	}

	@Test
	void testFindOrder() {
		int orderNum;
		bevShop.startNewOrder(8,Day.MONDAY,"Kate", 20);
		bevShop.processCoffeeOrder("americano", Size.SMALL, true, false);
		bevShop.processCoffeeOrder("Cappuccino", Size.LARGE, false, false);
		bevShop.processSmoothieOrder("Morning SunShine", Size.LARGE, 4, true);
		
		orderNum = bevShop.getCurrentOrder().getOrderNo();
		
		
	}

	@Test
	void testTotalOrderPrice() {
		int orderNum1;
		
		bevShop.startNewOrder(8,Day.MONDAY,"Kate", 20);
		bevShop.processCoffeeOrder("americano", Size.SMALL, true, false); 
		bevShop.processCoffeeOrder("Cappuccino", Size.LARGE, false, false);
		bevShop.processCoffeeOrder("Latte", Size.LARGE,true, true);
		
		orderNum1 = bevShop.getCurrentOrder().getOrderNo();

	
	}

	@Test
	void testTotalMonthlySale() {
		bevShop.startNewOrder(8,Day.MONDAY,"Kate", 20);
	bevShop.processCoffeeOrder("americano", Size.SMALL, true, false); 
	bevShop.processCoffeeOrder("Cappuccino", Size.LARGE, false, false);
	bevShop.processCoffeeOrder("Latte", Size.LARGE,true, true);
	}

	@Test
	void testSortOrders() {
		bevShop.startNewOrder(8,Day.MONDAY,"Kate", 20);
		bevShop.startNewOrder(8,Day.SUNDAY,"John", 30);
		bevShop.startNewOrder(12,Day.SATURDAY,"Amy", 43);
		
		bevShop.sortOrders();
		assertTrue(bevShop.getOrderAtIndex(0).getOrderNo()< bevShop.getOrderAtIndex(1).getOrderNo());	 
		assertTrue(bevShop.getOrderAtIndex(1).getOrderNo()< bevShop.getOrderAtIndex(2).getOrderNo());
	}

	@Test
	void testToString() {
		bevShop.startNewOrder(8,Day.MONDAY,"Kate ", 20);
		bevShop.processCoffeeOrder("americano ", Size.SMALL, true, false); 
		bevShop.processCoffeeOrder("Cappuccino ", Size.LARGE, false, false);
		 
			  
		 
		assertTrue(bevShop.toString().contains( String.valueOf(bevShop.getOrderAtIndex(0).getOrderNo()) ));
		assertTrue(bevShop.toString().contains(bevShop.getOrderAtIndex(0).getCustomer().getName()) );
		assertTrue(bevShop.toString().contains(bevShop.getOrderAtIndex(0).getBeverage(0).getSize().toString()) )  ;
		assertTrue(bevShop.toString().contains(bevShop.getOrderAtIndex(0).getBeverage(0).getBevName()) );
		
		
	}

}
