package google_on_site;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

import oa.GlobalOrder;

public class Test2 {

	public static void main(String[] args) {
		On_Site_2 oSite_2 = new On_Site_2();
		int[] arr1 = new int[] {1, 2, 3, 4, 5};
		int[] arr2 = new int[] {2, 3, 4, 5, 6};
		System.out.println(oSite_2.lengthOfSubfixEqualsPrefix(arr1, arr2));
		
		KMP_String_Matching kmp_String_Matching = new KMP_String_Matching();
		System.out.println(kmp_String_Matching.search("AABAACAADAABAABA", "AABA"));
		
		int[][] grid = new int[][] {
			new int[] {0, 0, 0},
			new int[] {0, 0, 1},
			new int[] {0, 0, 0}
		};
		System.out.println(oSite_2.countSquares(grid));
		
		Car car = new Car();
		System.out.println(car.position("AARAARA"));
		System.out.println(car.orders(7));
		
		RangeSum rangeSum = new RangeSum(arr1);
		System.out.println(rangeSum.sum(1, 4));
		rangeSum.update(2, 4);
		System.out.println(rangeSum.sum(1, 4));
		
		Trie trie = new Trie();
		Set<Character> set = new HashSet<>();
		set.addAll(Arrays.asList(new Character[] {'a', 't', 'e', 'n'}));
		trie.insertCharSet(set);
		System.out.println(trie.search("aate"));
		
		int[] arr = new int[] {2, 1, 3, 4, 5, 4, 5, 6, 7, 8};
		System.out.println(oSite_2.canDivideByK(arr, 5));
		
		Successor successor = new Successor();
		successor.birth("O", "A");
		successor.birth("O", "B");
		successor.birth("A", "AA");
		successor.birth("B", "BA");
		successor.death("A");
		successor.death("B");
		System.out.println(successor.successorList());
		
		GlobalOrder gOrder = new GlobalOrder();
		List<List<String>> list = new ArrayList<>();
		String[] s1 = new String[] {"e1", "e2", "e3"};
		String[] s2 = new String[] {"e2"};
		String[] s3 = new String[] {"e2", "e4", "e3"};
		list.add(new ArrayList<>(Arrays.asList(s1)));
		list.add(new ArrayList<>(Arrays.asList(s2)));
		list.add(new ArrayList<>(Arrays.asList(s3)));
		System.out.println(gOrder.getGlobalOrder(list));
		
		System.out.println(oSite_2.MaxNumMatchingSubseq("chatte", new String[] {"hat", "cat", "hate"}));
		
		N809 n809 = new N809();
		System.out.println(n809.isSimilar("heeellooo", "hello"));
		
//		TreeMap<Integer, Integer> treeMap = new TreeMap<>();
	}
}