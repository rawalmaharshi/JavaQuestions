
public class Subs1 {
	
	private static String [] subs (String s) {
		
		if(s.length() == 0) {
			String ans[] = {""};
			return ans;
		}
		
		String [] smallAns = subs(s.substring(1));
		String [] ans = new String [smallAns.length * 2];
		
		for (int i = 0; i < smallAns.length; i++) {
			ans[i] = smallAns[i];
		}
		
		for (int i = 0; i < smallAns.length; i++) {
			ans[i + smallAns.length] = s.charAt(0) + smallAns[i];
		}
		
		return ans;
	}

	public static void main(String[] args) {
		
		String s = "maharshi";
		String ans[] = subs(s);
		
		for (int i = 0; i < ans.length; i++) {
			System.out.println(ans[i]);
		}
	}

}
