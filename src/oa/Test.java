package oa;

public class Test {

	public static void main(String[] args) {
		System.out.println(Bloomberg.deleteDuplication("AABBCCCBD"));
//		char[][] ch = new char[][] {new char[] {'a', 'b'}, new char[] {'c', 'd'}};
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
		
		Bloomberg bloomberg = new Bloomberg();
		System.out.println(bloomberg.valid6digits(012210));
		bloomberg.missingWords("How about today and today is a nice day", "How and today nice");
		bloomberg.missingWords2("How about today and today is a nice day", "nice and how today");
	}

}
