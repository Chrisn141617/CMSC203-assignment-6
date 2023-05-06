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
public class Coffee extends Beverage{
	boolean extraShot;
	boolean extraSyrup;
	final double SHOT_PRICE = .5;
	final double SYRUP_PRICE = .5;
	
	public Coffee(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		super(bevName, Type.COFFEE, size);
		this.extraShot = extraShot;
		this.extraSyrup = extraSyrup;
	}
	
	public boolean getExtraShot() {
		return extraShot;
	}
	public boolean getExtraSyrup() {
		return extraSyrup;
	}
	public double calcPrice() {
		double price = super.addSizePrice();
		
		if(extraShot == true) {
			price += SHOT_PRICE;
		}else if(extraSyrup == true) {
			return price += SYRUP_PRICE;
		}
		return price;
	}
	@Override
	public String toString() {
		String toReturn = super.toString();
		toReturn += "," + extraShot + "," + extraSyrup + "," + calcPrice();
		return toReturn;
	}
	
	public boolean equals(Coffee anotherBev) {
		if(super.equals(anotherBev) == true && extraShot == anotherBev.extraShot && extraSyrup == anotherBev.extraSyrup) {
			return true;
		}else {
			return false;
		}
	}
}
