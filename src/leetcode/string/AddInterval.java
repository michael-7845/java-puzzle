package leetcode.string;

import static d.M.p;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
Problem:
Given a set of non-overlapping & sorted intervals, insert a new interval into the intervals (merge if necessary).

Example 1:
Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

Example 2:
Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 */

public class AddInterval {
	
	public static Interval[] insert(Interval[] intervals, Interval val) {
		List<Interval> result = new ArrayList<Interval>();
		
		if(intervals==null || intervals.length==0)
			return new Interval[]{val};
		
		Arrays.sort(intervals, new Comparator<Interval>(){
			public int compare(Interval i1, Interval i2) {
				if(i1.start!=i2.start) {
					return i1.start-i2.start;
				} else {
					return i1.end-i2.end;
				}
			}
		});
		
		int curIndex = 0;
		Interval add = val;
		while(curIndex<intervals.length) {
			Interval cur = intervals[curIndex];
			if(add.end<cur.start) {
				result.add(add);
				break;
			} else if(add.start<cur.end){
				Interval merge = new Interval(Math.min(add.start, cur.start), Math.max(add.end, cur.end));
				add = merge;
			} else {
				result.add(cur);
			}
			curIndex++;
		}
		if(curIndex == intervals.length) {
			result.add(add);
		} else {
			for(int index=curIndex; index<intervals.length; index++) {
				result.add(intervals[index]);
			}
		}
		
		p(result);
		return result.toArray(new Interval[result.size()]);
	}
	
	public static void demo() { 
		//Example 1:
		//Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
		p("example 1");
		Interval[] intervals = {new Interval(1,3), new Interval(6, 9)};
		Interval[] result = insert(intervals, new Interval(2, 5));
		for(Interval i: result) {
			p(i);
		}
		
		//Example 2:
		//Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
		p("example 2");
		Interval[] intervals2 = {new Interval(1,2), new Interval(3,5), new Interval(6,7), new Interval(8,10), new Interval(12,16)};
		Interval[] result2 = insert(intervals2, new Interval(4, 9));
		for(Interval i: result2) {
			p(i);
		}
		
		//Example 3:
		//Given [1,2],[3,5],[8,10],[6,7],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
		p("example 3");
		Interval[] intervals3 = {new Interval(1,2), new Interval(3,5), new Interval(8,10), new Interval(6,7), new Interval(12,16)};
		Interval[] result3 = insert(intervals3, new Interval(4, 9));
		for(Interval i: result3) {
			p(i);
		}
		
		//Example 4:
		//Given intervals [2,5],[6,9], insert and merge [1,3] in as [1,5],[6,9].
		p("example 4");
		Interval[] intervals4 = {new Interval(2,5), new Interval(6, 9)};
		Interval[] result4 = insert(intervals4, new Interval(1, 3));
		for(Interval i: result4) {
			p(i);
		}		
		
		//Example 5:
		//Given intervals [1,2],[6,9], insert and merge [4,5] in as [1,2],[4,5],[6,9].
		p("example 5");
		Interval[] intervals5 = {new Interval(1,2), new Interval(6, 9)};
		Interval[] result5 = insert(intervals5, new Interval(4, 5));
		for(Interval i: result5) {
			p(i);
		}	
		
		//Example 6:
		//Given intervals [4,5],[6,9], insert and merge [1,2] in as [1,2],[4,5],[6,9].
		p("example 6");
		Interval[] intervals6 = {new Interval(4,5), new Interval(6, 9)};
		Interval[] result6 = insert(intervals6, new Interval(1, 2));
		for(Interval i: result6) {
			p(i);
		}	
		
		//Example 7:
		//Given intervals [1,2],[4,5], insert and merge [6,9] in as [1,2],[4,5],[6,9].
		p("example 7");
		Interval[] intervals7 = {new Interval(1, 2), new Interval(4,5), };
		Interval[] result7 = insert(intervals7, new Interval(6, 9));
		for(Interval i: result7) {
			p(i);
		}		
	}

	public static void main(String[] args) {
		demo();
	}

}
