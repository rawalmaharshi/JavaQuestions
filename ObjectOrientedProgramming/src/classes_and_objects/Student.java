package classes_and_objects;

public class Student {
	public String name;
	private final int rollNumber;
    private static int numStudents;
	
//	You can also have multiple constructors
	
//	public Student() {
//		rollNumber = 10; //sets a default value for all students
//	}
	
//	public Student(String n) { //Sets the name passed in the constructor call
//		name = n;
//	}
    
    public static int getNumStudents () {
    	return numStudents;
    }
	
	public Student(String name, int rollNumber) {
//		System.out.println(this);
		this.name = name;
		this.rollNumber = rollNumber;
		numStudents++;
	}
	
//	public void setRollNumber(int rn) {
//		if(rn <=0 ) {
//			return;
//		}
//		rollNumber = rn;
//	}
	
	public int getRollNumber() {
		return rollNumber;
	}
	
	public void print() {
		System.out.println(name + ": " + rollNumber );
	}
}
