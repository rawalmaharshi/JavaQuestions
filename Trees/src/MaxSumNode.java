import java.util.Scanner;

public class MaxSumNode {
	
	static Scanner s = new Scanner(System.in);
	
	public static TreeNode<Integer> maxSumNode(TreeNode<Integer> root){
		//edge case
		if (root == null) {
			return null;
		}
		
		TreeNode<Integer> ans = root;
		int largerSum = root.data;
		for ( int i = 0; i < root.children.size(); i++) {
			largerSum += root.children.get(i).data;
		}
		
//		For each loop to traverse the tree:
//		for(TreeNode<Integer> child : root.children){ sum+= child.data; }
		
		for (int i = 0; i < root.children.size(); i++) {
			TreeNode<Integer> childNode= maxSumNode(root.children.get(i));
			int childSum = childNode.data;
			for (int j = 0; j < childNode.children.size(); j++) {
				childSum += childNode.children.get(j).data;
			}
			
			if (childSum > largerSum) {
				ans = childNode;
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
		TreeNode<Integer> root =  takeInputLevelWise();
		TreeNode<Integer> ans = maxSumNode(root);
		if(ans == null){
			System.out.println(Integer.MIN_VALUE);
		}else{
			System.out.println(ans.data);
		}
		
	}

}
