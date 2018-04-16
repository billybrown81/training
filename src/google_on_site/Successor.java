package google_on_site;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Successor {
	class P {
		String name;
		String parent;
		List<String> children;
		boolean isDead;
		public P(String name, String parent) {
			this.name = name;
			this.parent = parent;
			children = new ArrayList<>();
			isDead = false;
		}
	}
	private String ancestor;
	private Map<String, P> map;
	public Successor() {
		ancestor = "";
		map = new HashMap<>();
	}
	
	
	public void birth(String parent, String child) {
		if (!map.containsKey(parent)) {
			P p = new P(parent, "");
			map.put(parent, p);
			ancestor = parent;
		}
		map.get(parent).children.add(child);
		P c = new P(child, parent);
		map.put(child, c);
	}
	
	public boolean death(String name) {
		if (!map.containsKey(name)) return false;
		map.get(name).isDead = true;
		return true;
	}
	
	public List<String> successorList() {
		List<String> res = new ArrayList<>();
		Helper(res, ancestor);
		return res;
	}

	private void Helper(List<String> res, String cur) {
		if (!map.get(cur).isDead) {
			res.add(cur);
		}
		for (String child : map.get(cur).children) {
			Helper(res, child);
		}
	}
}
