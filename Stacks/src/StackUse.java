
public class StackUse {

	public static void main(String[] args) throws StackFullException {
		
		StackUsingArray s = new StackUsingArray();
		
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

	}

}
