import java.util.Scanner;

public class HeightOfTree {
	
	static Scanner s = new Scanner(System.in);
	
	public static int height(TreeNode<Integer> root){
		if (root == null) {
			return 0;
		}
		
		int height = 0;
		for (int i = 0; i < root.children.size(); i++) {
			int childHeight = height(root.children.get(i));
			if (childHeight > height) {
				height = childHeight;
			}
 		}
//		System.out.println(height);
		return height + 1;
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
		TreeNode<Integer> root =  takeInputLevelWise();
		System.out.println(height(root));

	}

}
