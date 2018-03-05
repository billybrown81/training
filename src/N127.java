import java.util.ArrayList;
import java.util.List;

public class N127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
    		List<String> reached = new ArrayList<String>();
        reached.add(beginWord);
        wordList.add(endWord);
        int distance = 1;
        while (!reached.contains(endWord)) {
			List<String> toAdd = new ArrayList<String>();
			for (String string : reached) {
        			for (int i = 0; i < string.length(); i++) {
        				char[] stringArray = string.toCharArray();
        				for (char ch = 'a'; ch <= 'z'; ch++) {
        					stringArray[i] = ch;
        					String word = new String(stringArray);
        					if (wordList.contains(word)) {
							if (word == endWord) return distance + 1;
        						toAdd.add(word);
							wordList.remove(word);
						}
        				}
        			}
			}
			distance++;
			if (toAdd.size() == 0) return 0;
			reached = toAdd;
		}
        return distance;
    }
}
