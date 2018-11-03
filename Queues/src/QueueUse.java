
public class QueueUse {

	public static void main(String[] args) throws QueueEmptyException, QueueFullException {
		QueueUsingArray queue = new QueueUsingArray();
		for (int i = 1; i <= 50; i++) {
			try {
				queue.enqueue(i);
			} catch (QueueFullException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		while (!queue.isEmpty()) {
			try {
				System.out.println(queue.deque());
			} catch (QueueEmptyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
