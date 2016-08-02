package leetcode.string;

import java.util.ArrayList;
import java.util.List;

import static d.M.*;

/*
Problem:

Given a set of non-overlapping & sorted intervals, insert a new interval into the intervals (merge if necessary).

Example 1:
Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

Example 2:
Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 */

public class InsertInterval {
	
	public static List<Interval> insert(List<Interval> intervals, Interval i) {
		List<Interval> result = new ArrayList<Interval>();
		
		for(Interval val: intervals) {
			if(val.end < i.start) {
				result.add(val);
			} else if(i.end < val.start) {
				result.add(i);
				result.add(val);
			} else {
				i = new Interval(Math.min(val.start, i.start), Math.max(val.end, i.end));
			}
		}
		
		return result;
	}
	
	public static void demo() {
		List<Interval> intervals = new ArrayList<Interval>() {{
			add(new Interval(1,3));
			add(new Interval(6,9));
		}};
		List<Interval> result = insert(intervals, new Interval(2, 5));
		p(result);
		
		intervals.clear(); 
		intervals.add(new Interval(1,2));
		intervals.add(new Interval(3,5));
		intervals.add(new Interval(6,7));
		intervals.add(new Interval(8,10));
		intervals.add(new Interval(12,16));
		result = insert(intervals, new Interval(4,9));
		p(result);
	}

	public static void main(String[] args) {
		demo();
	}

}
