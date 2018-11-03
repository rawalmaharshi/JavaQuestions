
public class GoodQuestion {
	public static void print(int n){
	    if(n < 0){
	        return;
	    }
	    if(n == 0){
	        System.out.println(n);
	        return;
	    }
	    
	    print(--n); //if the call is (n--) It gives error
	    
	    /*In function print when recursion call is being made, n-- is being passed as input. 
	     * Here we are using post decrement operator, so argument passed to next function call is n and not n - 1. 
	     * Thus there will be infinite recursion calls and StackOverflow exception. */
	    System.out.print(n+" ");
	}

	public static void main(String[] args) {
	    int num = 3;
	    print(num);
	}
}
