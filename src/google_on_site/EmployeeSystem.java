package google_on_site;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class EmployeeSystem {
	class employee {
		String name;
		String manager;
		Set<employee> peers;
		public employee(String name) {
			this.name = name;
			this.manager = "";
			peers = new HashSet<>();
		}
	}
	Map<String, employee> employees = new HashMap<>();
	public void manages(String m, String e) {
		if (!employees.containsKey(e)) {
			employee e1 = new employee(e);
			e1.manager = m;
			employees.put(e, e1);
		} else if (employees.get(e).manager == "") {
			employees.get(e).manager = m;
			for (employee peer : employees.get(e).peers) {
				peer.manager = m;
			}
		}
	}
	
	public void peer(String e1, String e2) {
		if (!employees.containsKey(e1)) {
			employee ee1 = new employee(e1);
			employees.put(e1, ee1);
		}
		if (!employees.containsKey(e2)) {
			employee ee2 = new employee(e2);
			employees.put(e2, ee2);
		}
		employees.get(e1).peers.add(employees.get(e2));
		employees.get(e2).peers.add(employees.get(e1));
		if (employees.get(e1).manager == "") {
			employees.get(e1).manager = employees.get(e2).manager;
		}
		if (employees.get(e2).manager == "") {
			employees.get(e2).manager = employees.get(e1).manager;
		}
	}
	
	public boolean isManaging(String e1, String e2) {
		if (!employees.containsKey(e2)) return false;
		String tmp = e2;
		while (employees.containsKey(tmp)) {
			String tmpM = employees.get(tmp).manager;
			if (e1.equals(tmpM)) return true;
			tmp = tmpM;
		}
		return false;
	}
	
}
