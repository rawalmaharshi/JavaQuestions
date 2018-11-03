import java.util.Scanner;

public class StackUse2 {

	public static void main(String[] args) throws StackEmptyException {
		
		StackUsingLL<Integer> s = new StackUsingLL<>();
		
		for (int i = 0; i < 10; i++) {
			s.push(i + 1);
		}
		
		while (!s.isEmpty()) {
			try {
				System.out.println(s.pop());
			} catch (StackEmptyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
//		Scanner s = new Scanner(System.in);
//		
//		StackUsingLL<Integer> st = new StackUsingLL<Integer>();
//
//		int choice = s.nextInt();
//		int input;
//
//		while (choice !=-1) {
//			if(choice == 1) {
//				input = s.nextInt();
//				st.push(input);
//			}
//			else if(choice == 2) {
//				try {
//					System.out.println(st.pop());
//				} catch (StackEmptyException e) {
//					System.out.println(-1);
//				}
//			}
//			else if(choice == 3) {
//				try {
//					System.out.println(st.top());
//				} catch (StackEmptyException e) {
//					System.out.println(-1);
//				}
//			}
//			else if(choice == 4) {
//				System.out.println(st.size());
//			}
//			else if(choice == 5) {
//				System.out.println(st.isEmpty());
//			}
//			choice = s.nextInt();
//		}
	}

}
