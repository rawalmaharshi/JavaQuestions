package subsmissions;

public class Power {
	
	public static int power(int x, int n) {
		/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
		 * Taking input and printing output is handled automatically.
		 */
		
		if(n == 0) {
			return 1;
		}
		
		return x * power(x, n-1); 
	}
	
	public static void main(String[] args) {
		int n = 4, x = 3;
		int ans = power(x,n);
		System.out.println(ans);
	}
}