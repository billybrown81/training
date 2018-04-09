package google_on_site;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
	}
}
