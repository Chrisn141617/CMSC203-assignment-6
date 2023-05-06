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
public class Smoothie extends Beverage{
	int numOfFruits;
	boolean addProtein;
	final double PROTEIN_PRICE = 1.50;
	final double FRUIT_PRICE = .5;
	
	public Smoothie(String bevName, Size size, int numOfFruits, boolean addProtein) {
		super(bevName, Type.SMOOTHIE, size);
		this.numOfFruits = numOfFruits;
		this.addProtein = addProtein;
	}
	
	public int getNumOfFruits() {
		return numOfFruits;
	}
	public boolean getAddProtein() {
		addProtein = true;
		return addProtein;
	}
	
	public String toString() {
		String toReturn = super.toString();
		toReturn += "," + addProtein + "," + numOfFruits + "," + calcPrice();
		
		return toReturn;
	}
	
	public double calcPrice() {
		double price = super.addSizePrice();
		price += numOfFruits * FRUIT_PRICE;
		if(addProtein == true) {
			price += PROTEIN_PRICE;
		}
		return price;
	}
	
	public boolean equals(Smoothie anotherBev) {
		if(super.equals(anotherBev) == true && numOfFruits == anotherBev.numOfFruits && addProtein == anotherBev.addProtein) {
			return true;
		}else {
			return false;
		}
	}
	
}
