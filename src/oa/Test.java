package oa;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		System.out.println(Bloomberg.deleteDuplication("AABBCCCBD"));
		char[][] ch = new char[][] {new char[] {'a', 'b'}, new char[] {'c', 'd'}};
//		if (Google_Phone.isSymmetric("ac", "bd", ch)) {
//			System.out.println("T");
//		}
//		else {
//			System.out.println("F");
//		}
		
		if (Google_Phone.isSameCharArray(new char[] {'a', 'b', '\b', 'd', 'c'}, new char[] {'a', 'd', 'c'})) {
			System.out.println("T");
		}
		else {
			System.out.println("F");
		}
		System.out.println(Google_Phone.weightedRandomNumber(new int[] {3,9}));
		System.out.println(Google_Phone.maxLength(3));
	}

}
