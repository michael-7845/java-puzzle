package algrithm.classic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static d.M.*;

public class Combination {
	
	public static void combine(String[] candidate, int target, int level, 
			List<Set<String>> result, Set<String> solution) {
		if(solution.size() == target) {
			result.add(new HashSet<String>(solution));
			p(solution);
			return;
		}
		for(int i=level; i<candidate.length; i++) {
			solution.add(candidate[i]);
			combine(candidate, target, level+1, result, solution);
			solution.remove(candidate[i]);
		}
	}
	
	public static void demo() {
		String[] cand = {"a", "b", "c", "d"};
		int target = 3;
		
		List<Set<String>> result = new ArrayList<Set<String>>();
		Set<String> solution = new HashSet<String>();
		combine(cand, target, 0, result, solution);
		p(result);
	}

	public static void main(String[] args) {
		demo();
	}

}
