package leetcode200_249;
import java.util.LinkedList;
import java.util.Queue;

public class N207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null) throw new IllegalArgumentException("Error");
        int len = prerequisites.length;
        if (numCourses == 0 || len == 0) return true;
        int[] pCount = new int[numCourses];
        for (int i = 0; i < len; i++) pCount[prerequisites[i][0]]++;
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) if (pCount[i] == 0) queue.add(i);
        int numNoPre = queue.size();
        while (!queue.isEmpty()) {
			int cur = queue.poll();
			for (int i = 0; i < len; i++) {
				if (prerequisites[i][1] == cur) {
					pCount[prerequisites[i][0]]--;
					if (pCount[prerequisites[i][0]] == 0) {
						numNoPre++;
						queue.add(prerequisites[i][0]);
					}
				}
			}
		}
        return numNoPre == numCourses;
    }
}
