import java.util.Scanner;

public class QueueUse2 {

	public static void main(String[] args) throws QueueEmptyException {
		
//		QueueUsingLL<Integer> queue = new QueueUsingLL<>();
//		for (int i = 1; i <= 50; i++) {
//			queue.enqueue(i);
//		}
//
//		while (!queue.isEmpty()) {
//			System.out.println(queue.dequeue());
//		}
		
		Scanner s = new Scanner(System.in);

		QueueUsingLL<Integer> st = new QueueUsingLL<Integer>();
		
		int choice = s.nextInt();
		int input;

		while (choice !=-1) {
			if(choice == 1) {
				input = s.nextInt();
				st.enqueue(input);
			}
			else if(choice == 2) {
				try {
					System.out.println(st.dequeue());
				} catch (QueueEmptyException e) {
					System.out.println(-1);
				}
			}
			else if(choice == 3) {
				try {
					System.out.println(st.front());
				} catch (QueueEmptyException e) {
					System.out.println(-1);
				}
			}
			else if(choice == 4) {
				System.out.println(st.size());
			}
			else if(choice == 5) {
				System.out.println(st.isEmpty());
			}
			choice = s.nextInt();
		}
		s.close();
	}

}
