package leetcode200_249;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class N210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) return null;
        int[] pcount = new int[numCourses], order = new int[numCourses];
        	int index = 0;
        for (int i = 0; i < prerequisites.length; i++)
			pcount[prerequisites[i][0]]++;
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++)
			if (pcount[i] == 0) {
				order[index++] = i;
				queue.add(i);
			}
        while (!queue.isEmpty()) {
			int cur = queue.poll();
			for (int i = 0; i < prerequisites.length; i++) {
				if (cur == prerequisites[i][1]) {
					pcount[prerequisites[i][0]]--;
					if (pcount[prerequisites[i][0]] == 0) {
						order[index++] = prerequisites[i][0];
						queue.add(prerequisites[i][0]);
					}
				}
			}
		}
        return (index == numCourses)? order : new int[0];
    }
}
