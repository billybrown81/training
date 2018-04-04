package google_on_site;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Race {
	
	List<DLinkedList> list;
	Map<Integer, Integer> checkPoints;
	Map<Integer, DLinkedNode> nodes;
	public Race() {
		list = new ArrayList<>();
		checkPoints = new HashMap<>();
		nodes = new HashMap<>();
	}
	
	public void update(int carNum, int checkPoint) {
		if (list.size() < checkPoint) {
			list.add(new DLinkedList());
		}
		DLinkedNode newNode = new DLinkedNode(carNum);
		list.get(checkPoint - 1).addToTail(newNode);
		if (checkPoints.containsKey(carNum) && nodes.containsKey(carNum)) {
			list.get(checkPoints.get(carNum) - 1).remove(nodes.get(carNum));
		}
		checkPoints.put(carNum, checkPoint);
		nodes.put(carNum, newNode);
	}
	
	public List<Integer> currentRank(){
		List<Integer> rank = new ArrayList<>();
		for (int i = list.size() - 1; i >= 0; i--) {
			DLinkedNode tmp = list.get(i).head.post;
			while (tmp.value != -1) {
				rank.add(tmp.value);
				tmp = tmp.post;
			}
		}
		return rank;
	}
}
