package oa;

import java.util.HashSet;
import java.util.Stack;

public class PS8 {
	public static int detectProblem(String[] strings){
		int len = strings.length;
		Stack<Integer> toRelease = new Stack<Integer>();
		for (int i = 0; i < strings.length; i++) {
			String command = strings[i];
			int lock = Integer.parseInt(command.substring(8, command.length()));
			if (command.startsWith("ACQUIRE")) {
				if (toRelease.contains(lock)) return i + 1;
				toRelease.add(lock);
			} else if (toRelease.isEmpty() || toRelease.pop() != lock) return i + 1;
		}
		if (toRelease.isEmpty()) return 0;
		return len + 1;
	}
	
    static int check_log_history(String[] events) {
    		int len = events.length;
    		if (events == null || len == 0) return 0;
    		Stack<Integer> toRelease = new Stack<Integer>();
    		//Use HashSet to perform quicker searches
    		HashSet<Integer> acquired = new HashSet<Integer>();
    		for (int i = 0; i < events.length; i++) {
    			String command = events[i];
    			//Acquire and Release have the same length
    			int lock = Integer.parseInt(command.substring(8, command.length()));
    			if (command.charAt(0) == 'A') {
    				if (acquired.contains(lock)) return i + 1;
    				toRelease.add(lock);
    				acquired.add(lock);
    			} else {
    				if (toRelease.isEmpty() || toRelease.pop() != lock) return i + 1;
    				acquired.remove(lock);
    			}
    		}
    		if (toRelease.isEmpty()) return 0;
    		return len + 1;
    }
}
