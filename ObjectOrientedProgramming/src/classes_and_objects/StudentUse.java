package classes_and_objects;

import java.util.Scanner;

public class StudentUse {

	public static void main(String[] args) {	
		Scanner s = new Scanner(System.in);
		
		Student s1 = new Student("Coding Ninja", 10);
		Student s2 = new Student("Maharshi", 11);
//		Student s3 = new Student();
//		System.out.println(s1);
		
		s1.print();
		s2.print();
//		s3.print();
		
		System.out.println(Student.getNumStudents());
		s.close();
	}
	
}
