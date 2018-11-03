import java.util.Scanner;

public class Relational {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int i = s.nextInt();
		int j = s.nextInt();
		
		boolean isEq = (i == j);
		boolean neq = (i != j);
		boolean isGr = (i > j);
		boolean isgreq = (i >= j);
		boolean isLes = (i < j);
		boolean isLeseq = (i <= j);
		
		System.out.println("Is equal: " + isEq);
		System.out.println("Is not equal: " + neq);
		System.out.println("Is greater: " + isGr);
		System.out.println("Is greater or equal: " + isgreq);
		System.out.println("Is less: " + isLes);
		System.out.println("Is less or equal: " + isLeseq);
		
//		byte b = 2;
//		b = b*1;
//		double a = 6 / 4;
//        int b  = 6 / 4;
//        double c = a + b;
//        System.out.println(c);
		
//		double a = 55.5;
//        int b = 55;
//        a = a % 10;
//        b = b % 10;
//        System.out.println(a + " "  + b);
        
        int var1 = 5;
        int var2 = 6;
        System.out.print(var1 > var2);
 
		s.close();
	}

}
