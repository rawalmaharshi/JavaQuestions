package tries;

import java.util.Scanner;

class TrieNode {
	char data;
	boolean isTerminating;
	TrieNode children[];
	
	public TrieNode(char data) {
		this.data = data;
		isTerminating = false;
		children = new TrieNode[26];
	}
}

public class Trie {
	
	private TrieNode root;
	
	public Trie () {
		root = new TrieNode('\0');
	}
	
	private void add (TrieNode root, String word) {
		//base case
		if (word.length() == 0) {
			root.isTerminating = true;
			return;
		}
		
		int childIndex = word.charAt(0) - 'a';
		TrieNode child = root.children[childIndex];
		
		if (child == null) {
			child = new TrieNode(word.charAt(0));
			root.children[childIndex] = child;
		}
		
		add(child, word.substring(1));
	}
	
	public void add(String word) {
		add(root, word);
	}
	
	private boolean search (TrieNode root, String word) {
		//base case
		if (word.length() == 0) {
			//you can simply return root.isTerminating
			if (root.isTerminating == true) {
				return true;
			}
			return false;
		}
		
		int childIndex = word.charAt(0) - 'a';
		TrieNode child = root.children[childIndex];
		
		if (child == null) {
			return false;
		}
		
		return search(child, word.substring(1));
	}
	
	public boolean search (String word) {
		return search(root, word);
	}
	
	static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {
		Trie t = new Trie();
		int choice = s.nextInt();
		
		while(choice != -1) {
			String word;
			switch(choice) {
				case 1 : // insert
					word = s.next();
					t.add(word);
					break;
				case 2 : // search
					word = s.next();
					System.out.println(t.search(word));
					break;
				default :
						return;
			}
			choice = s.nextInt();
		}
	}

}
