import java.util.Scanner;
import java.util.Stack;

public class StockSpan {
	
	public static int[] stockSpan1(int[] price) {
		int ans[] = new int[price.length];
		
		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		
		ans[0] = 1;
		 
		for (int i = 1; i < price.length; i++) {
			
			while ( !stack.isEmpty() && price[stack.peek()] < price[i]) 
				stack.pop();
			
			ans[i] = (stack.isEmpty() ? (i+1) : (i - stack.peek()));
			stack.push(i);
		}
		return ans;
	}
	
	public static int[] stockSpan(int[] price) {
		int ans[] = new int[price.length];
		int ansIndex = 0;
		
		for(int i = 0; i < price.length; i++) {
			int countOfSmallerElements = 1, j = 0;
			Stack<Integer> stack = new Stack<>();
			while(j <= i) {
				stack.push(price[j]);
				j++;
			}
			
			while(!stack.isEmpty()) {
				int elem = stack.pop();
				if (elem > price[i]) {
					break;
				} else if (elem == price[i]) {
					continue;
				} else
					countOfSmallerElements++;
			}
			ans[ansIndex] = countOfSmallerElements;
			ansIndex++;
		}
		return ans;
	}
	
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		int size = s.nextInt();
		int[] input = new int[size];
		for(int i = 0; i < size; i++) {
			input[i] = s.nextInt();
		}
		int output[] = stockSpan1(input);
		for(int i = 0; i < size; i++) {
			System.out.print(output[i] + " ");
		}
	}

}
