package Program;

import java.util.Comparator;

public class MyComparator implements Comparator<Actor>{

	@Override
	public int compare(Actor o1, Actor o2) {
		return Double.compare(o1.getDistance(), o2.getDistance());
	}
	
}
