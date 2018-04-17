package google_on_site;
//676. Implement Magic Dictionary

public class MagicDictionary {
	class TrieNode {
		TrieNode[] children = new TrieNode[26];
		boolean isWord;
		public TrieNode() {}
	}
	TrieNode root;
    /** Initialize your data structure here. */
    public MagicDictionary() {
        root = new TrieNode();
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for (String word : dict) {
        		TrieNode cur = root;
			for (int i = 0; i < word.length(); i++) {
				int index = word.charAt(i) - 'a';
				if (cur.children[index] == null) {
					cur.children[index] = new TrieNode();
				}
				cur = cur.children[index];
			}
			cur.isWord = true;
		}
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
    		char[] arr = word.toCharArray();
        for (int i = 0; i < word.length(); i++) {
			for (char c = 'a'; c <= 'z'; c++) {
				if (c == arr[i]) continue;
				char org = arr[i];
				arr[i] = c;
				if (searchTree(new String(arr))) {
					return true;
				}
				arr[i] = org;
			}
		}
        return false;
    }

	private boolean searchTree(String word) {
		TrieNode cur = root;
		for (char c : word.toCharArray()) {
			if (cur.children[c - 'a'] == null) return false;
			cur = cur.children[c - 'a'];
		}
		return cur.isWord;
	}
}
