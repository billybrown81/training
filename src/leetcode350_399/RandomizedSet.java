package leetcode350_399;
//380. Insert Delete GetRandom O(1)

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomizedSet {
	Map<Integer, Integer> map;
	List<Integer> list;
	Random random;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        map.put(val, list.size());
        list.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int pos = map.get(val);
        if (pos < list.size() - 1) {
			int lastNum = list.get(list.size() - 1);
			list.set(pos, lastNum);
			map.put(lastNum, pos);
		}
        list.remove(list.size() - 1);
        map.remove(val);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
    
//	Map<Integer, Integer> map_val;
//	Map<Integer, Integer> map_idx;
//	int size;
//	Random random;
//    /** Initialize your data structure here. */
//    public RandomizedSet() {
//        map_val = new HashMap<>();
//        map_idx = new HashMap<>();
//        random = new Random();
//        size = 0;
//    }
//    
//    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
//    public boolean insert(int val) {
//        if (map_idx.containsKey(val)) return false;
//        map_idx.put(val, size);
//        map_val.put(size++, val);
//        return true;
//    }
//    
//    /** Removes a value from the set. Returns true if the set contained the specified element. */
//    public boolean remove(int val) {
//        if (!map_idx.containsKey(val)) return false;
//        int pos = map_idx.get(val);
//        if (pos < size - 1) {
//			int lastVal = map_val.get(size - 1);
//			map_val.put(pos, lastVal);
//			map_idx.put(lastVal, pos);
//		}
//        map_idx.remove(val);
//        map_val.remove(size - 1);
//        size--;
//        return true;
//    }
//    
//    /** Get a random element from the set. */
//    public int getRandom() {
//        return map_val.get(random.nextInt(size));
//    }
}
