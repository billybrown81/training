package google_on_site;

import java.util.HashSet;
import java.util.Set;

public class Trie {
	final int alphabet_size = 26;
	class TrieNode {
		TrieNode[] children = new TrieNode[alphabet_size];
		boolean isEnd;
		public TrieNode() {
			isEnd = false;
			for (int i = 0; i < alphabet_size; i++) {
				children[i] = null;
			}
		}
	}
	
	TrieNode root = new TrieNode();
	public void insertString(String key) {
		TrieNode cur = root;
		for (int i = 0; i < key.length(); i++) {
			int index = key.charAt(i) - 'a';
			if (cur.children[index] == null) {
				cur.children[index] = new TrieNode();
			}
			cur = cur.children[index];
		}
		cur.isEnd = true;
	}
	
	public void insertCharSet(Set<Character> set) {
		helper(root, set);
	}

	private void helper(TrieNode cur, Set<Character> set) {
		for (Character c : set) {
			int index = c - 'a';
			if (cur.children[index] == null) {
				cur.children[index] = new TrieNode();
			}
			Set<Character> newSet = new HashSet<>(set);
			cur.children[index].isEnd = true;
			newSet.remove(c);
			helper(cur.children[index], newSet);
		}
	}
	
	public boolean search(String key) {
		TrieNode cur = root;
		for (int i = 0; i < key.length(); i++) {
			int index = key.charAt(i) - 'a';
			if (cur.children[index] == null) return false;
			cur = cur.children[index];
		}
		return cur.isEnd;
	}
}
