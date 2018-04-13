package google_on_site;

public class Test2 {

	public static void main(String[] args) {
		On_Site_2 oSite_2 = new On_Site_2();
		int[] arr1 = new int[] {1, 2, 3, 4, 5};
		int[] arr2 = new int[] {2, 3, 4, 5, 6};
		System.out.println(oSite_2.lengthOfSubfixEqualsPrefix(arr1, arr2));
	}

}
