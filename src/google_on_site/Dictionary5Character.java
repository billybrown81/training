package google_on_site;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Dictionary5Character {
	int size = 26;
	class TrieNode {
		TrieNode[] children = new TrieNode[size];
		boolean isEnd;
		public TrieNode() {
			isEnd = false;
		}
	}
	TrieNode root;
	int[] indexes;
	Character[] chs = new Character[] {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
	public Dictionary5Character() {
		root = new TrieNode();
		indexes = new int[5];
		Set<Character> set = new HashSet<>(Arrays.asList(chs));
		helper(root, set, 0);
	}
	private void helper(TrieNode cur, Set<Character> set, int i) {
		if (i >= 5) {
			cur.isEnd = true;
			return;
		}
		for (Character c : set) {
			int index = c - 'a';
			cur.children[index] = new TrieNode();
			set.remove(c);
			helper(cur.children[index], set, i + 1);
			set.add(c);
		}
	}
	
	public String next() {
		return "";
	}
}
