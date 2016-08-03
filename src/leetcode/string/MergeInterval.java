package leetcode.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static d.M.*;

/*
Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].
 */

public class MergeInterval {
	
	public static Interval[] merge(Interval[] intervals) {
		if(intervals==null || intervals.length==0)
			return intervals;
		
		Arrays.sort(intervals, new Comparator<Interval>(){
			public int compare(Interval i1, Interval i2) {
				if(i1.start!=i2.start) {
					return i1.start-i2.start;
				} else {
					return i1.end-i2.end;
				}
			}
		});
		
		Interval pre = intervals[0];
		List<Interval> result = new ArrayList<Interval>();
		for(int index=1; index<intervals.length; index++) {
			Interval cur = intervals[index];
			if(pre.end<cur.start) {
				result.add(pre);
				pre = cur;
			} else {
				Interval merge = new Interval(pre.start, Math.max(pre.end, cur.end));
				pre = merge;
			}
		}
		result.add(pre);
		p(result);
		return result.toArray(new Interval[result.size()]);
	}
	
	public static void demo() { 
		Interval[] intervals = {new Interval(1,3), new Interval(2,6), new Interval(8,10), new Interval(15,18)};
		Interval[] result = merge(intervals);
		for(Interval i: result) {
			p(i);
		}
	}

	public static void main(String[] args) {
		demo();
	}

}

class Interval {
	int start;
	int end;
	public Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}
	public String toString() {
		return "["+start+", "+end+"]";
	}
}
