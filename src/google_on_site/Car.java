package google_on_site;

import java.util.ArrayList;
import java.util.List;

public class Car {
	
	public int position(String orders) {
		int V = 1;
		int pos = 0;
		for (char c : orders.toCharArray()) {
			if (c == 'A') {
				pos += V;
				V *= 2;
			} else if (c == 'R') {
				V = -V;
			}
		}
		return pos;
	}
	
	public List<String> orders(int target) {
		List<String> res = new ArrayList<>();
		DFSHelper(res, new StringBuilder(), target, 0, 1);
		return res;
	}

	private void DFSHelper(List<String> res, StringBuilder path, int target, int pos, int v) {
		if (path.length() > 10) return;
		if (pos == target) {
			res.add(path.toString());
			return;
		}
		DFSHelper(res, new StringBuilder(path).append("A"), target, pos + v, v * 2);
		DFSHelper(res, new StringBuilder(path).append("RA"), target, pos - v, 0 - v * 2);
	}
}