package tries;

import java.util.ArrayList;
import java.util.Scanner;

class TrieNode3 {
	char data;
	boolean isTerminating;
	TrieNode3 children[];
	int childCount;

	public TrieNode3(char data) {
		this.data = data;
		isTerminating = false;
		children = new TrieNode3[26];
		childCount = 0;
	}
}

public class PatternMatching {

	private TrieNode3 root;

	public PatternMatching() {
		root = new TrieNode3('\0');
	}

	private void add(TrieNode3 root, String word) {
		if (word.length() == 0) {
			root.isTerminating = true;
			return;
		}
		int childIndex = word.charAt(0) - 'a';
		TrieNode3 child = root.children[childIndex];
		if (child == null) {
			child = new TrieNode3(word.charAt(0));
			root.children[childIndex] = child;
			root.childCount++;
		}
		add(child, word.substring(1));
	}

	public void add(String word) {
		add(root, word);
	}

	public boolean patternMatching(ArrayList<String> input, String pattern) {
		PatternMatching pm = new PatternMatching();
		for (int i = 0; i < input.size(); i++) {
			String currString = input.get(i);
			
			pm.add(currString);
			while (currString.length() != 0) {
				currString = currString.substring(1);
				pm.add(currString);
			}
		}
		
		boolean ans = pm.search(pattern);
		return ans;
	}
	
	private boolean search(TrieNode3 root, String word) {
		// base case
		if (word.length() == 0) {
			return true;
		}

		int childIndex = word.charAt(0) - 'a';
		TrieNode3 child = root.children[childIndex];

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
		PatternMatching t = new PatternMatching();
		int n = s.nextInt();
		ArrayList<String> input = new ArrayList<String>();
		for (int i = 0; i < n; i++) {
			String word = s.next();
			input.add(word);
		}
		String pattern = s.next();
		System.out.println(t.patternMatching(input, pattern));
	}
}
