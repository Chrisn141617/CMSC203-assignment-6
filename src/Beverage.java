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
public abstract class Beverage {
	private String name;
	private Type type;
	private Size size;
	private final double BASE_PRICE = 2.0;
	private final double SIZE_PRICE = 1.0;
	public boolean weekend = false;
	
	public Beverage(String bevName, Type Type, Size Size) {
		name = bevName;
		type = Type;
		size = Size;
	}
	
	public abstract double calcPrice();
	
	public double addSizePrice() {
		if(size == Size.SMALL) {
			return BASE_PRICE;
		}else if(size == Size.MEDIUM){
			return BASE_PRICE + SIZE_PRICE;
		}else {
			return BASE_PRICE + 2 * SIZE_PRICE;
		}
	}
	
	public boolean equals(Beverage bev) {
		if(name.equals(name) && type == bev.type && size == bev.size) {
			return true;
		}else {
			return false;
		}
	}
	
	public double getBasePrice() {
		return BASE_PRICE;
	}
	public String getBevName() {
		return name;
	}
	public Size getSize() {
		return size;
	}
	public Type getType() {
		return type;
	}
	public String toString() {
		return name + ", " + size;
	}
	
}
