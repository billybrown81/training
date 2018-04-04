package google_on_site;

public class DLinkedList {
	DLinkedNode head, tail;
	public DLinkedList() {
		head = new DLinkedNode(-1);
		tail = new DLinkedNode(-1);
		head.pre = null;
		tail.post = null;
		head.post = tail;
		tail.pre = head;
	}
	
	public void addToTail(DLinkedNode node) {
		node.pre = tail.pre;
		node.pre.post = node;
		tail.pre = node;
		node.post = tail;
	}
	
	public void remove(DLinkedNode node) {
		node.pre.post = node.post;
		node.post.pre = node.pre;
	}
}
