package tries;

import java.util.ArrayList;
import java.util.Scanner;

class TrieNode4 {

	char data;
	boolean isTerminating;
	TrieNode4 children[];
	int childCount;

	public TrieNode4(char data) {
		this.data = data;
		isTerminating = false;
		children = new TrieNode4[26];
		childCount = 0;
	}
}

public class PalindromePair {

	private TrieNode4 root;
	public int count;

	public PalindromePair() {
		root = new TrieNode4('\0');

	}

	private void add(TrieNode4 root, String word) {
		if (word.length() == 0) {
			if (!root.isTerminating) {
				root.isTerminating = true;
			}
			return;
		}
		int childIndex = word.charAt(0) - 'a';
		TrieNode4 child = root.children[childIndex];
		if (child == null) {
			child = new TrieNode4(word.charAt(0));
			root.children[childIndex] = child;
			root.childCount++;
		}
		add(child, word.substring(1));

	}

	public void add(String word) {
		add(root, word);
	}

	public boolean findPalindromePair(ArrayList<String> input) {
		PalindromePair pm = new PalindromePair();
		for (int i = 0; i < input.size(); i++) {
			pm.add(input.get(i));
		}
		
		for (int i = 0; i < input.size(); i++) {
			String word1 = input.get(i);
			String word2 = input.get(i).substring(0, input.get(i).length() - 1);
			 
			word1 = new StringBuilder(word1).reverse().toString();
			word2 = new StringBuilder(word2).reverse().toString();
			
			System.out.println("1-->" + word1);
			System.out.println("2-->" + word2);
			
			boolean isWord1Present = pm.search(word1);
			boolean isWord2Present = pm.search(word2);
			
			if (isWord1Present == true || isWord2Present == true) {
				return true;
			}
		}
		return false;
	}
	
	private boolean search(TrieNode4 root, String word) {
		// base case
		if (word.length() == 0) {
			return root.isTerminating;
		}

		int childIndex = word.charAt(0) - 'a';
		TrieNode4 child = root.children[childIndex];

		if (child == null) {
			return false;
		}

		return search(child, word.substring(1));
	}

	public boolean search(String word) {
		return search(root, word);
	}

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		int n = s.nextInt();
		ArrayList<String> input = new ArrayList<String>();
		for (int i = 0; i < n; i++) {
			String word = s.next();
			input.add(word);
		}
		PalindromePair t = new PalindromePair();
		System.out.println(t.findPalindromePair(input));
	}
}
