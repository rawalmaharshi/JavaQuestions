import java.util.Scanner;

public class SecondLargest {

	static Scanner s = new Scanner(System.in);
	
	private static MaxAndSecondMax findSecondMax (TreeNode <Integer> root) {
		//edge case
		if (root == null) {
			return null;
		}
		
		MaxAndSecondMax ans = new MaxAndSecondMax();
		ans.max = root;
		ans.secondMax = null;
//		TreeNode<Integer> largest = root, secondLargest = null;
		
		for (int i = 0; i < root.children.size(); i++) {
			MaxAndSecondMax smallAns = findSecondMax(root.children.get(i));
			if (ans.secondMax == null && smallAns.secondMax == null) {
				if(ans.max.data < smallAns.max.data) {
					ans.secondMax = ans.max;
					ans.max = smallAns.max;
				} else {
					ans.secondMax = smallAns.max;
				}
			}
						
			else if (ans.secondMax == null ) {
				if (ans.max.data < smallAns.max.data) {
					TreeNode<Integer> temp = ans.max;
					ans.max = smallAns.max;
					if (temp.data < smallAns.secondMax.data) {
						ans.secondMax = smallAns.secondMax;
					} else {
						ans.secondMax = temp;
					}
				}
				
				if (ans.max.data > smallAns.max.data) {
					ans.secondMax = smallAns.max;
				}
			}
					
			else if (smallAns.secondMax == null)  {
				if (ans.max.data > smallAns.max.data) {
					TreeNode<Integer> temp = ans.secondMax;
					if (temp.data < smallAns.max.data) {
						ans.secondMax = smallAns.max;
					}
				}
				
				if (ans.max.data < smallAns.max.data) {
					ans.secondMax = ans.max;
					ans.max = smallAns.max;
				}
			}
			
			else {
				if (ans.max.data > smallAns.max.data) {
					TreeNode<Integer> temp = smallAns.max;
					
					if (temp.data > ans.secondMax.data) {
						ans.secondMax = temp;
					}
				} else {
					TreeNode<Integer> temp = ans.max;
					ans.max = smallAns.max;
					if ( temp.data > smallAns.secondMax.data) {
						ans.secondMax = temp;
					} else  {
						ans.secondMax = smallAns.secondMax;
					}
				}
			}
		}
		return ans;
	}
	
	public static TreeNode<Integer> findSecondLargest(TreeNode<Integer> root){
		MaxAndSecondMax ans = findSecondMax(root);
		return ans.secondMax;
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
		TreeNode<Integer> ans = findSecondLargest(root);
		if(ans == null){
			System.out.println(Integer.MIN_VALUE);
		}else{
			System.out.println(ans.data);
		} 
	}
}

class MaxAndSecondMax {
	TreeNode<Integer> max;
	TreeNode<Integer> secondMax;
}
