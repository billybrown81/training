package google_on_site;

import java.util.LinkedList;
import java.util.List;

public class Reconstruction {
	
	public int[] rec(int[] arr) {
		int n = arr.length;
		List<Integer> list = new LinkedList<>();
		for (int i = n - 1; i >= 0; i--) {
			list.add(i + 1);
		}
		for (int i = n - 1; i >= 0; i--) {
			int tmp = arr[i];
			arr[i] = list.get(tmp);
			list.remove(tmp);
		}
		return arr;
	}
}
