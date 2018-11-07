import java.util.Scanner;

public class TreeUse2 {
	
	public static TreeNode<Integer> takeInput(Scanner s) {
		System.out.print("Enter next node data: ");
		int n = s.nextInt();
		TreeNode<Integer> root = new TreeNode<Integer>(n);
		
		System.out.print("Enter number of children for " + n + ": ");
		int childCount = s.nextInt();
		
		for (int i = 0; i < childCount; i++) {
			TreeNode<Integer> child = takeInput(s);
			root.children.add(child);
		}
		return root;
	}
	
	public static void print(TreeNode<Integer> root) {
		String s = root.data + ": ";
		for (int i = 0; i < root.children.size(); i++) {
			s += root.children.get(i).data + ", ";
		}
		System.out.println(s);
		
		for (int i = 0 ; i < root.children.size(); i++) {
			print(root.children.get(i));
		}
	}
	 
	public static void main (String [] args) {
		Scanner s = new Scanner(System.in);
		TreeNode<Integer> root = takeInput(s);
		print(root);
		s.close();
	}

}
