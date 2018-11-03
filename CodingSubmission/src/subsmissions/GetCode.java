package subsmissions;

import java.util.Scanner;

public class GetCode {
	
	public static  String[] getCode(String input, int ansArrayIndex){
		// base case
		if(input.length() == 1) {
			String [] ans = new String[1];
//			char i = (char)(input.charAt(0) + 'a' - '1');
//			String s = Character.toString(i);
//			ans[0] = s;
			return ans;
		}

		String [] smallAns = getCode(input.substring(1), ansArrayIndex);
		String [] finalAns = new String[smallAns.length];
		
		return finalAns;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String input = s.next();																																																																				
		String output[] = getCode(input, 0);
		for(int i = 0; i < output.length; i++) {
			System.out.println(output[i]);
		}
		s.close();
	}
}
