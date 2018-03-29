package leetcode100_149;

import java.util.Hashtable;

public class LRUCache {
	
	class DLinkedNode{
		int key;
		int value;
		DLinkedNode pre;
		DLinkedNode post;
	}
	
	private void addNode(DLinkedNode node) {
		node.pre = head;
		node.post = head.post;
		head.post.pre = node;
		head.post = node;
	}
	
	private void removeNode(DLinkedNode node) {
		DLinkedNode pre = node.pre;
		DLinkedNode post = node.post;
		pre.post = post;
		post.pre = pre;
	}
	
	private void moveToHead(DLinkedNode node) {
		this.removeNode(node);
		this.addNode(node);
	}
	
	private DLinkedNode popTail() {
		DLinkedNode pre = tail.pre;
		this.removeNode(pre);
		return pre;
	}
	
	
	private Hashtable<Integer, DLinkedNode> cache = new Hashtable<>();
	private int count;
	private int capacity;
	private DLinkedNode head, tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.pre = null;
        tail.post = null;
        head.post = tail;
        tail.pre = head;
    }
    
    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
			return -1;
		}
        this.moveToHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node != null) {
			node.value = value;
			this.moveToHead(node);
		} else {
			DLinkedNode newNode = new DLinkedNode();
			newNode.key = key;
			newNode.value = value;
			
			this.cache.put(key, newNode);
			this.addNode(newNode);
			
			count++;
			
			if (count > capacity) {
				DLinkedNode tail = this.popTail();
				cache.remove(tail.key);
				count--;
			}
		}
    }
}
