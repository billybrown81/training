package leetcode400_449;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

//406. Queue Reconstruction by Height
//Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k), where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.
//
//Note:
//The number of people is less than 1,100.
public class N406 {
    public int[][] reconstructQueue(int[][] people) {
    		if (people == null || people.length == 0 || people[0].length == 0)
    			return new int[0][0];
        Arrays.sort(people, new Comparator<int[]>() {

			@Override
			public int compare(int[] a, int[] b) {
				if (a[0] == b[0]) {
					return a[1] - b[1];
				}
				return b[0] - a[0];
			}
		});;
		List<int[]> tmp = new LinkedList<>();
		for (int[] person : people) {
			tmp.add(person[1], person);
		}
		int[][] res = new int[people.length][2];
		for (int i = 0; i < res.length; i++) {
			res[i][0] = tmp.get(i)[0];
			res[i][1] = tmp.get(i)[1];
		}
		return res;
		
    }
}
