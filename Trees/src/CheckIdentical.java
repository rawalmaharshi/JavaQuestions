import java.util.Scanner;

public class CheckIdentical {
	
	static Scanner s = new Scanner(System.in);
	
	public static boolean checkIdentical(TreeNode<Integer> root1, TreeNode<Integer> root2){
		//edge case
		if (root1 == null && root2 == null) {
			return true;
		}
		
		if (root1 == null || root2 == null) {
			return false;
		}
		
		boolean ans = root1.data == root2.data ? true : false;
		
		if (root1.children.size() != root2.children.size()) {
			return false;
		}
		
		for (int i = 0; i < root1.children.size(); i++) {
			boolean smallAns = checkIdentical(root1.children.get(i), root2.children.get(i));
			if(smallAns == false) {
				return smallAns;
			}
		}
		
		return ans;
	}

	public static TreeNode<Integer> takeInputLevelWise(){
		QueueUsingLL<TreeNode<Integer>> pendingNodes = new QueueUsingLL<TreeNode<Integer>>();  // Queue of node that are entered themselves but their children aren't added yet
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
		TreeNode<Integer> root1 =  takeInputLevelWise();
		TreeNode<Integer> root2 = takeInputLevelWise();
		System.out.println(checkIdentical(root1, root2));
	}

}
