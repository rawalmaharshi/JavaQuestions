package generics;

import vehicle.Vehicle;

public class Print {
	
	public static <T extends PrintInterface> void printArray (T a[]) {
		for (int i = 0; i < a.length; i++) 
			a[i].print();
		System.out.println();
	}

	public static void main(String[] args) {
		Integer a[] = new Integer[10];
		for(int i = 0; i < 10; i++) 
			a[i] = i + 1;
		
//		printArray(a);
		
		Character [] b = new Character[10];
		for (int i = 0; i < b.length; i++)
			b[i] = (char) (i + 97);
		
//		printArray(b);
		
		String [] c = new String[10];
		for (int i = 0; i < c.length; i++)
			c[i] = "abc";
		
//		printArray(c);
		
		Vehicle [] v = new Vehicle[10];
		for (int i = 0; i < v.length; i++)
			v[i] = new Vehicle(10);
		
		printArray(v);
	}

}
