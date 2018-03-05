import java.util.HashMap;

public class N133 {
	private HashMap<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        if (map.containsKey(node.label)) return map.get(node.label);
        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        map.put(node.label, clone);
        for (UndirectedGraphNode neighbor : node.neighbors) {
			clone.neighbors.add(cloneGraph(neighbor));
		}
        return clone;
    }
}
