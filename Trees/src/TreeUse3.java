import java.util.Scanner;

public class TreeUse3 {
	static Scanner s = new Scanner(System.in);
	
	public static void printPreOrder(TreeNode<Integer> root) {
		//edge case
		if (root == null) {
			return;
		}
		
		System.out.print(root.data + " ");
		for (int i = 0; i < root.children.size(); i++) {
			printPreOrder(root.children.get(i));
		}
	}
	
	public static void printAtK(TreeNode<Integer> root, int k) {
		if ( k < 0) {
			return ;
		}
		
		if (k == 0) {
			System.out.println(root.data);
			return; 
		}
		
		for (int i = 0; i < root.children.size(); i++) {
			printAtK(root.children.get(i), k - 1);
		}
	}
	
	public static int largestNode (TreeNode<Integer> root) {
		//edge case
		if (root == null) {
			return Integer.MIN_VALUE;
		}
		
		int ans = root.data; //yaa to yeh largest hai nahi to jo child nodes se data aayega woh
		
		for (int i = 0; i < root.children.size(); i++) {
			int childLargest  = largestNode(root.children.get(i));
			if (childLargest > ans) {
				ans = childLargest;
			}
		}
		
		return ans;
	}
	
	public static int numNodes (TreeNode<Integer> root) {
		//This is not base case, this is edge case
		if (root == null) {
			return 0;
		}
		
		int count = 1;
		for (int i = 0 ; i < root.children.size(); i++) {
			count += numNodes(root.children.get(i));
		}
		
		return count;
	}
	
	public static TreeNode<Integer> takeInputLevelWiseMine() {
		
		System.out.println("Enter the data for root node");
		int rootData = s.nextInt();
		TreeNode<Integer> root = new TreeNode<Integer>(rootData);
		QueueUsingLL<TreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
		pendingNodes.enqueue(root);
		
		while (!pendingNodes.isEmpty()) {
			try {
				TreeNode<Integer> frontNode = pendingNodes.dequeue();
				System.out.println("Enter the number of children for " + frontNode.data);
				int childNum = s.nextInt();
				
				for (int i = 0; i < childNum; i++) {
					System.out.println("Enter the child #" + (i + 1) + " of " + frontNode.data);
					int childData = s.nextInt();
					
					TreeNode<Integer> childNode = new TreeNode<Integer>(childData);
					frontNode.children.add(childNode);
					pendingNodes.enqueue(childNode);
				}	
			} catch (QueueEmptyException e) {
				// shouldn't reach here as already checked for isEmpty in while clause
				s.close();
				return null;
			}
		}
		s.close();
		return root;
	}
	
	public static void printLevelWise(TreeNode<Integer> root) {
		QueueUsingLL<TreeNode<Integer>> que = new QueueUsingLL<>();
		que.enqueue(root);
		
		while(!que.isEmpty()) {
			try {
				TreeNode<Integer> frontNode = que.dequeue();
				String s = frontNode.data + ": ";
				
				for (int i = 0; i < frontNode.children.size(); i++) {
					s += frontNode.children.get(i).data + ", ";
					que.enqueue(frontNode.children.get(i));
				}
				System.out.println(s);
			} catch (QueueEmptyException e) {
				//Doesn't reach here
			}
			
		}
	}
	
	public static void printLevelWise2(TreeNode<Integer> root) {
		QueueUsingLL<TreeNode<Integer>> que = new QueueUsingLL<>();
		que.enqueue(root);
		System.out.println(root.data);
		
		while(!que.isEmpty()) {
			try {
				TreeNode<Integer> frontNode = que.dequeue();
				
				
				if (frontNode.children.size() > 0) {
					for (int i = 0; i < frontNode.children.size(); i++) {
						System.out.print(frontNode.children.get(i).data + " ");
						que.enqueue(frontNode.children.get(i));
					}
					System.out.println();
				}	
			} catch (QueueEmptyException e) {
				//Doesn't reach here
			}
		}
	}
	
	public static void printLevelWiseSir(TreeNode<Integer> root){
  		QueueUsingLL<TreeNode<Integer>> pendingNodes = new QueueUsingLL<TreeNode<Integer>>();
  		pendingNodes.enqueue(root);
  		pendingNodes.enqueue(null);
  		while(!pendingNodes.isEmpty()){
  			TreeNode<Integer> currentNode;
  			try {
  				currentNode = pendingNodes.dequeue();
  				if(currentNode==null){
  					System.out.println();
  					if(!pendingNodes.isEmpty()){
  						pendingNodes.enqueue(null);
  						continue;
  					}else{
  						break;
  					}
  				}
  				if (pendingNodes.front() == null)  {
  					System.out.print(currentNode.data);
  				} else {
  					System.out.print(currentNode.data+" ");
  				}
  				
  				int numChild = currentNode.children.size();
  				for(int i = 0 ; i < numChild; i++){
  					pendingNodes.enqueue(currentNode.children.get(i));
  				}

  			} catch (QueueEmptyException e) {
  			}
  		}
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
		TreeNode<Integer> root = takeInputLevelWise();
//		printLevelWise(root);
		printLevelWiseSir(root);
//		System.out.println("No. of nodes: " + numNodes(root));
//		System.out.println("Largest Node: " + largestNode(root));
//		printAtK(root, 2);
//		printPreOrder(root);
	}

}
