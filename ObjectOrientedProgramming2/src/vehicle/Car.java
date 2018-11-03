package vehicle;

public abstract class Car extends Vehicle{
	int numGears;
	boolean isCovertible;
	
	public Car() {
		
	}
	
	public Car (int numGears, int maxSpeed){
		super(100);
		this.numGears = numGears;
		System.out.println("Car Constructor");
	}
	
	public void print() {	
		super.print();
		System.out.println("Car Gears: " + numGears);
		System.out.println("Is Car Convertible? " + isCovertible);
	}

	@Override
	public boolean isMotorized() {
		return false;
	}
}


