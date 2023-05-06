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
import java.util.ArrayList;

public class BevShop implements BevShopInterface{
	private int numOfAlc_Drinks;
	private ArrayList<Beverage> bevList = new ArrayList<>();
	private int time;
	private Day orderDay;
	private String customer;
	private int customerAge;
	private final int MIN_AGE = 21;
	private final int MAX_ALC_DRINKS = 3;
	private final int MAX_FRUIT = 5;
	private ArrayList<Order> orderList = new ArrayList<>();
	private Order Order;
	
	
	public BevShop() {
		
		}
	
	public boolean isValidTime(int time) {
		if(time >= 8 && time <= 23) {
			return true;
		}else {
			return false;
		}
	}
	
	public int getMaxNumOfFruits() {
		return MAX_FRUIT;
	}
	
	public int getMinAgeForAlcohol() {
		return MIN_AGE;
	}
	
	public boolean isMaxFruit(int numOfFruits) {
		if(numOfFruits > MAX_FRUIT) {
			return true;
		}else {
			return false;
		}
	}
	
	public int getMaxOrderForAlcohol() {
		return MAX_ALC_DRINKS;
	}
	
	public boolean isEligibleForMore() {
		int count = 0;
		boolean reachMax = false;
		for(int i = 0; i < bevList.size(); i++) {
			if(bevList.get(i).getType().equals(Type.ALCOHOL)) {
				count++;
				if(count == MAX_ALC_DRINKS) {
					reachMax = true;
				}
			}
		}
		return reachMax;
	}
	
	public int getNumOfAlcoholDrink() {
		return numOfAlc_Drinks;
	}
	
	public boolean isValidAge(int age) {
		if(age >= MIN_AGE) {
			return true;
		}else {
			return false;
		}
	}
	
	public void startNewOrder(int time, Day day, String customerName, int customerAge) {
		Order = new Order(time, day, new Customer(customerName, customerAge));
		
		orderList.add(Order);
	}
	
	public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		Order.addNewBeverage(bevName, size, extraShot, extraSyrup);
	}
	
	public void processAlcoholOrder(String bevName, Size size) {
		Order.addNewBeverage(bevName, size);
	}
	
	public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein) {
		Order.addNewBeverage(bevName, size, numOfFruits, addProtein);
	}
	
	public int findOrder(int orderNo) {
		int found = 0;
		for(int i = 0; i < orderList.size(); i++) {
			if(orderList.get(i).getOrderNo() == orderNo) {
				found = i;
			}else {
				found = -1;
			}
		}return found;
	}
	
	public double totalOrderPrice(int orderNo) {
		double total = 0;
		
		for(int i = 1; i < orderList.size(); i++) {
			if(orderList.get(i).getOrderNo() == orderNo) {
				total += Order.calcOrderTotal();
			}
		}return total;
	}
	
	public double totalMonthlySale() {
		double total = 0;
		
		for(int i = 0; i < orderList.size(); i++) {
			double highestOrderTotal = totalOrderPrice(0);
			int highestOrderIndex = 0;
			if(totalOrderPrice(i) > highestOrderTotal) {
				highestOrderTotal = totalOrderPrice(i);
				highestOrderIndex = i;
			}
		}
		for(int i = 0; i < orderList.size(); i++) {
			System.out.println(orderList.get(i));
		}
		return total;
	}
	
	public int totalNumOfMonthlyOrders() {
		int total = 0;
		for(int i = 0; i < orderList.size(); i++) {
			total += totalOrderPrice(i);
		}return total;
	}
	
	public Order getCurrentOrder() {
		return Order;
	}
	
	public Order getOrderAtIndex(int index) {
		return orderList.get(index);
		
	}
	public void sortOrders() {
		for(int i = 1; i < orderList.size(); i++) {
			double highestOrderTotal = totalOrderPrice(0);
			int highestOrderIndex = 0;
			
			if(totalOrderPrice(i) > highestOrderTotal) {
				highestOrderTotal = totalOrderPrice(i);
				highestOrderIndex = i;
			}
		}
		for(int i = 0; i < orderList.size(); i++) {
			System.out.println(orderList.get(i));
		}
	}
	
	@Override
	public String toString() {
		String str = "Order: \n" + totalMonthlySale() + "\n";
		return str + " Monthly Sales: " + totalMonthlySale();
	}
	
	
	
	public BevShop(int numOfAlc_Drinks, ArrayList<Beverage> bevList, int time, Day orderDay, String customer, ArrayList<Order> orderList) {
		this.numOfAlc_Drinks = numOfAlc_Drinks;
		this.bevList = bevList;
		this.time = time;
		this.orderDay = orderDay;
		this.customer = customer;
		this.orderList = orderList;
	}
	
	public BevShop(BevShop obj) {
		this.numOfAlc_Drinks = obj.numOfAlc_Drinks;
		this.bevList = obj.bevList;
		this.time = obj.time;
		this.orderDay = obj.orderDay;
		this.customer = obj.customer;
		this.orderDay = obj.orderDay;
	}
	
	
	public void setNumOfAlcDrink(int numOfAlc_Drinks) {
		this.numOfAlc_Drinks = numOfAlc_Drinks;
	}
	
	public ArrayList<Beverage> getBevList(){
		return bevList;
	}
	
	public void setBevList(ArrayList<Beverage> bevList) {
		this.bevList = bevList;
	}
	
	public Day getOrderDay() {
		return orderDay;
	}
	
	public void setOrderDay(Day orderDay) {
		this.orderDay = orderDay;
	}
	
	public String getCustomer() {
		return customer;
	}
	
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	
	public int getCustomerAge() {
		return customerAge;
	}
	
	public void setCustomerAge(int customerAge) {
		this.customerAge = customerAge;
	}
	
	public ArrayList<Order> getOrderList(){
		return orderList;
	}
	
	public void setOrderList(ArrayList<Order> orderList) {
		this.orderList = orderList;
	}

}

	