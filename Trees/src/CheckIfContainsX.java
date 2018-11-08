import java.util.Scanner;

public class CheckIfContainsX {
	
	static Scanner s = new Scanner(System.in);
	
	public static boolean checkIfContainsX(TreeNode<Integer> root, int x){
		//edge case
		if (root == null) {
			return false;
		}
		
		boolean ans = (x == root.data) ? true : false;
		
		for (int i = 0 ; i < root.children.size(); i++) {
			boolean smallAns = checkIfContainsX(root.children.get(i), x);
			if (smallAns == true) {
				return true;
			}
		}
		return ans;
	}

	public static TreeNode<Integer> takeInputLevelWise(){
		QueueUsingLL<TreeNode<Integer>> pendingNodes = new QueueUsingLL<TreeNode<Integer>>();  // Queue of nodes that are entered themselves but their children aren't added yet
		int rootData = s.nextInt();
		TreeNode<Integer> root = new TreeNode<Integer>(rootData);
		pendingNodes.enqueue(root);
		while(!pendingNodes.isEmpty()){
			TreeNode<Integer> currentNode;
			try {
				currentNode = pendingNodes.dequeue();
				int numChild = s.nextInt();
				for(int i = 0 ; i < numChild; i++){
					int currentChild = s.nextInt();
					TreeNode<Integer> childNode = new TreeNode<Integer>(currentChild);
					pendingNodes.enqueue(childNode);
					currentNode.children.add(childNode);
				}
			} catch (QueueEmptyException e) {
			}
		}
		return root;
	}


	public static void main(String[] args) {
		int x = s.nextInt();
		TreeNode<Integer> root =  takeInputLevelWise();
		System.out.println(checkIfContainsX(root, x));
	}
}
