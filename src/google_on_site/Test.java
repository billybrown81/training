package google_on_site;

import java.util.ArrayList;
import java.util.List;

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
	}
}
