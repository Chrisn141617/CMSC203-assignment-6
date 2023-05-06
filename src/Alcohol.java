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

public class Alcohol extends Beverage{
	boolean isWeekend;
	final double WEEKEND_PRICE = .60;
	
	public Alcohol(String bevName, Size size, boolean isWeekend) {
		super(bevName, Type.ALCOHOL, size);
		this.isWeekend = isWeekend;
	}
	
	public double calcPrice() {
		double price = super.addSizePrice();
		if(isWeekend == true) {
			price += WEEKEND_PRICE;
		}return price;
	}
	@Override
	public String toString() {
		String toReturn = super.toString();
		toReturn += "," + isWeekend + "," + calcPrice();
		return toReturn;
	}
	
	public boolean equals(Alcohol anotherBev) {
		if(super.equals(anotherBev) == true && isWeekend == anotherBev.isWeekend) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean isWeekend() {
		return isWeekend;
	}
}
