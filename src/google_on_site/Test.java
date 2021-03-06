package google_on_site;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Test {

	public static void main(String[] args) {
		On_Site oSite = new On_Site();
		System.out.println(oSite.isSubsequence("AXY", "ADXCPY"));
		System.out.println(oSite.isSubsequence("AXD", "ADXCPY"));
		
		Race race = new Race();
		race.update(0, 1);
		race.update(1, 1);
		race.update(2, 1);
		race.update(2, 2);
		System.out.println(race.currentRank());
		
		Presidency presidency = new Presidency();
		List<Vote> list = new ArrayList<>();
		list.add(new Vote(1, "A"));
		list.add(new Vote(2, "A"));
		list.add(new Vote(5, "B"));
		list.add(new Vote(1000, "C"));
		list.add(new Vote(1005, "B"));
		list.add(new Vote(2000, "B"));
		presidency.build(list);
		System.out.println(presidency.currentWinner(2000));
		
		TwoStrings twoStrings = new TwoStrings();
		System.out.println(twoStrings.generate("ab", "cd"));
		Random random = new Random();
		System.out.println(random.nextInt(100));
		
		Reconstruction reconstruction = new Reconstruction();
		System.out.println(reconstruction.rec(new int[] {0, 1, 2, 1, 0})[4]);
		
		RandomBS randomBS = new RandomBS();
		System.out.println(randomBS.validElements(new int[] {5, 1, 4, 3, 6, 8, 10, 7, 9}));
		
		System.out.println(oSite.minTwoes(7));
		System.out.println(oSite.minTwoesN(7));
		
		Integer[] arr = new Integer[] {0,1,2,3,4,5};
		List<Integer> list2 = Arrays.asList(arr);
		Integer[] arr2 = new Integer[] {0,1,3};
		Set<Integer> set = new HashSet<>(Arrays.asList(arr2));
		System.out.println(oSite.containsSublist(list2, set));
		
		int[][] matrix = new int[][] {
				new int[] {1, 0, 0, 1, 0},
				new int[] {0, 0, 1, 0, 1},
				new int[] {0, 0, 0, 1, 0},
				new int[] {1, 0, 1, 0, 1}
		};
		System.out.println(oSite.hasRec(matrix));
		
		System.out.println(oSite.areBuddies("conserve", "converse"));
		System.out.println(oSite.areBuddiesN("listen", "silent", 5));
		
		System.out.println(oSite.p21());
		
		Integer[] b = new Integer[] {0, 0, 1, 0, 0, 0, 1, 0};
		Bench bench = new Bench(b);
		bench.addPerson();
		System.out.println(Arrays.asList(bench.arr));
		bench.addPerson();
		System.out.println(Arrays.asList(bench.arr));
		
		int[][] points = new int[][] {
			new int[] {0, 0},
			new int[] {2, 1},
			new int[] {3, 3},
			new int[] {1, 4}
		};
		int[] point = new int[] {2, 4};
		System.out.println(oSite.isIn(points, point));
		
		List<List<Integer>> list3 = new ArrayList<>();
		Integer[] arr1 = new Integer[] {1, 2, 4, 5};
		Integer[] arr02 = new Integer[] {2, 4};
		Integer[] arr3 = new Integer[] {6};
		Integer[] arr4 = new Integer[] {5};
		list3.add(Arrays.asList(arr1));
		list3.add(Arrays.asList(arr02));
		list3.add(Arrays.asList(arr3));
		list3.add(Arrays.asList(arr4));
		System.out.println(oSite.numberOfClusters(list3));
		System.out.println(oSite.numberOfClusters2(list3));
	}
}
