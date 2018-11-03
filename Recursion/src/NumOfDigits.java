public class NumOfDigits {
	public static int count(int n){
		if(n == 0){
			return 0;
		}
		int smallAns = count(n / 10);
		return smallAns + 1;
	}
	
	public static void main(String[] args) {
		int n = 1;
		int ans = count(n);
		System.out.println(ans);
	}
}
