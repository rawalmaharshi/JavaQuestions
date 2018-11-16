package bst;

public class BinarySearchTree {
	
	private BinaryTreeNode<Integer> root;
	
	private BinaryTreeNode<Integer> insertDataHelper (int data, BinaryTreeNode<Integer> root) {
		//base case
		if (root == null) {
			BinaryTreeNode<Integer> newNode = new BinaryTreeNode<Integer>(data);
			return newNode;
		}
		
		if (root.data > data) {
			root.left = insertDataHelper(data, root.left);
		} else {
			root.right = insertDataHelper(data, root.right);
		}
		
		return root;
	}
	
	public void insertData (int data) {
		root = insertDataHelper(data, root);
	}
	
	private BinaryTreeNode<Integer> deleteDataHelper(int data, BinaryTreeNode<Integer> root) {
		//base case
		if (root == null) {
			return null;
		}
		
		if (data < root.data) {
			root.left = deleteDataHelper(data, root.left);
			return root;
		} else if (root.data < data) {
			root.right = deleteDataHelper(data, root.right);
			return root;
		} else {
			if (root.left == null && root.right == null) {
				return null;
			} else if (root.left == null) {
				return root.right;
			} else if (root.right == null) {
				return root.left;
			} else {
				BinaryTreeNode<Integer> miNode = root.right;
				while (miNode.left != null) {
					miNode = miNode.left;
				}
				
				root.data = miNode.data;
				root.right = deleteDataHelper(miNode.data, root.right);
				return root;
			}
		}
	}
	
	public void deleteData (int data) {
		root = deleteDataHelper (data, root);
	}
	
	private boolean hasDataHelper(int data, BinaryTreeNode<Integer> root) {
		if (root == null) {
			return false;
		}
		
		if (root.data == data) {
			return true;
		} else if (root.data < data) {
			return hasDataHelper(data, root.right);
		} else {
			return hasDataHelper(data, root.left);
		}
	} 
	
	public boolean hasData (int data) {
		return hasDataHelper (data, root);
	}
	
	public void printTree () {
		printTree(root);
	}

	private void printTree (BinaryTreeNode<Integer> root) {
		// base case
		if (root == null) {
			return;
		}
		
		String toBePrinted = root.data + " --> ";
		if (root.left != null) {
			toBePrinted += "L:" + root.left.data + ", ";
		}
		
		if (root.right != null) {
			toBePrinted += "R:" + root.right.data;
		}
		
		System.out.println(toBePrinted);
		
		printTree(root.left);
		printTree(root.right);
	}

}
