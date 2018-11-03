
public class DataType {

	public static void main(String[] args) {
		char c = 'a';
		System.out.println(c + 3);
		
		int i = c + 10;
		System.out.println(i);
		
//		char abc = i; Error b'coz char takes 2 bytes and int takes 4 bytes. So it is unable to copy 4 bytes into 2 bytes.
		
		char abc = (char)i ;//Explicit type casting
		
		long l = i;
		l = 12345677891015L;
		i = (int)l;
		
		System.out.println(l);
		System.out.println(i);
		
		System.out.println('a' + 1);
		
		float f = 1.4f; //Error in 1.4
	}

}
