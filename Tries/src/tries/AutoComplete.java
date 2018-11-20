package tries;

import java.util.ArrayList;
import java.util.Scanner;

class TrieNode5 {
	char data;
	boolean isTerminating;
	TrieNode5 children[];
	int childCount;

	public TrieNode5(char data) {
		this.data = data;
		isTerminating = false;
		children = new TrieNode5[26];
		childCount = 0;
	}
}

public class AutoComplete {

	private TrieNode5 root;

	public AutoComplete() {
		root = new TrieNode5('\0');
	}

	private void add(TrieNode5 root, String word) {
		if (word.length() == 0) {
			root.isTerminating = true;
			return;
		}
		int childIndex = word.charAt(0) - 'a';
		TrieNode5 child = root.children[childIndex];
		if (child == null) {
			child = new TrieNode5(word.charAt(0));
			root.children[childIndex] = child;
			root.childCount++;
		}
		add(child, word.substring(1));
	}

	public void add(String word) {
		add(root, word);
	}

	public void autoComplete(ArrayList<String> input, String word) {
		AutoComplete t = new AutoComplete();
		for (int i = 0; i < input.size(); i++) {
			t.add(input.get(i));
		}
		
		TrieNode5 wordRoot = findWord (t.root, word);
		
		if (wordRoot != null) {
//			System.out.println(wordRoot.data);
			String op = "";
			allPossibleWords(wordRoot, word, op);
		}
		return;
	}

	private TrieNode5 findWord(TrieNode5 root, String word) {
		//base case
		if (word.length() == 0) {
			return root;
		}

		int childIndex = word.charAt(0) - 'a';
		TrieNode5 child = root.children[childIndex];
		
		if (child == null) {
			return null;
		}

		return findWord(child, word.substring(1));
	}
	
	private void allPossibleWords (TrieNode5 root, String word, String op) {
		//base case
		if (root == null) {
			return;
		}
		
		if (root.isTerminating) {
			System.out.println(word + op);
		}
		
		for (int i = 0; i < 26; i++) {
			if (root.children[i] != null) {
				TrieNode5 child = root.children[i];
				allPossibleWords(child, word, op + child.data);
			}
		}
	}

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		AutoComplete t = new AutoComplete();
		int n = s.nextInt();
		ArrayList<String> input = new ArrayList<String>();
		for (int i = 0; i < n; i++) {
			String word = s.next();
			input.add(word);
		}
		String pattern = s.next();
		t.autoComplete(input, pattern);
	}

}
