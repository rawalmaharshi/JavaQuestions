
public class HelloWorld {

		public static void main (String args[]) {
			System.out.print("Hello World!");
			System.out.println("Hello World!");
			System.out.println("Hello World!");
//			int i = 18;
//			int i = 15; Error
//			System.out.println(i);
//			int [] x = new int[0];
//			System.out.println(x.length);
//			int [][] a = {{}};
//			int [][] b = new int[2 * a.length][];
//			int bArrayIndex = 0;
//			for ( int i = 0; i < a.length; i++) {
//					b[bArrayIndex] = new int[a[i].length];
//					bArrayIndex++;
//			}
//			for (int i = 0 ; i < a.length; i++) {
//				b[bArrayIndex] = new int[a[i].length + 1];
//				bArrayIndex++;
//			}
//			System.out.println(a[0][0]);
//			System.out.println(b[1][0]);
		
			String output = new String();
			String input = "gi";
			for (int i = 0; i < input.length(); i++) {
				String newString1 = input.substring(0, i);
				String newString2 = input.substring(i + 1);
				String finalString = newString1.concat(newString2);
				output = finalString;
				System.out.print(input.charAt(i) + " " );
				System.out.println(finalString);
			}
//			String b = new String();
//			b += (char)(a.charAt(0) + 'a' - '1');
//			b += (char)(a.charAt(1) + 'a' - '1');
//			System.out.println(b);
//			System.out.println((char)(a.charAt(0) + 'a' - '1'));
		}
}
