package kemin.puzzle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static d.M.*;
import static kemin.puzzle.CrossRiverThing.*;

/*
 * 一个人在河边，带着一只狼，一只羊和一颗卷心菜
 * 他需要将这三样东西运到对岸，然后这艘船的空间有限，智能容下他自己和另一样东西。
 * 如果他不在场，狼会吃羊，羊会吃卷心菜
 * 此人如何才能把这三个乘客送至对岸。
 */

// XXXX 未完成!!!!!!!!!!!!!!!!!!!!!!
public class CrossRiver {
//public enum CrossRiverThing {
//	p, w, s, c; // person, wolf, sheep, cabbage
//}
	
	List<Set<CrossRiverThing>> ok = new ArrayList<Set<CrossRiverThing>>() {{
		add(new HashSet<CrossRiverThing>(Arrays.asList(new CrossRiverThing[]{p, w, s, c})));
		add(new HashSet<CrossRiverThing>(Arrays.asList(new CrossRiverThing[]{p, w, s})));
		add(new HashSet<CrossRiverThing>(Arrays.asList(new CrossRiverThing[]{p, w, c})));
		add(new HashSet<CrossRiverThing>(Arrays.asList(new CrossRiverThing[]{p, s, c})));
		add(new HashSet<CrossRiverThing>(Arrays.asList(new CrossRiverThing[]{p, w})));
		add(new HashSet<CrossRiverThing>(Arrays.asList(new CrossRiverThing[]{p, s})));
		add(new HashSet<CrossRiverThing>(Arrays.asList(new CrossRiverThing[]{p, c})));
		add(new HashSet<CrossRiverThing>(Arrays.asList(new CrossRiverThing[]{p})));
		add(new HashSet<CrossRiverThing>(Arrays.asList(new CrossRiverThing[]{w, c})));
		add(new HashSet<CrossRiverThing>(Arrays.asList(new CrossRiverThing[]{s})));
		add(new HashSet<CrossRiverThing>(Arrays.asList(new CrossRiverThing[]{c})));
	}};
	
	List<Set<CrossRiverThing>> boatOk = new ArrayList<Set<CrossRiverThing>>() {{
		add(new HashSet<CrossRiverThing>(Arrays.asList(new CrossRiverThing[]{p, w})));
		add(new HashSet<CrossRiverThing>(Arrays.asList(new CrossRiverThing[]{p, s})));
		add(new HashSet<CrossRiverThing>(Arrays.asList(new CrossRiverThing[]{p, c})));
		add(new HashSet<CrossRiverThing>(Arrays.asList(new CrossRiverThing[]{p})));
	}};
	
	List<Set<CrossRiverThing>> solution = new ArrayList<Set<CrossRiverThing>>();
	
	List<Set<CrossRiverThing>> bHistory = new ArrayList<Set<CrossRiverThing>>();
	
	final static Set<CrossRiverThing> target = new HashSet<CrossRiverThing>(Arrays.asList(new CrossRiverThing[]{p, w, s, c}));
	
	Set<CrossRiverThing> preBoat = new HashSet<CrossRiverThing>(); 
	
	
	
	Set<CrossRiverThing> a = new HashSet<CrossRiverThing>(
			Arrays.asList(new CrossRiverThing[]{p, w, s, c}));
	Set<CrossRiverThing> b = new HashSet<CrossRiverThing>();
	
	public boolean isSafe() {
//		p("isSafe() 1");
//		print(a);
//		print(b);
//		print(ok);
		if((ok.contains(a)) && (ok.contains(b))) {
			return true;
		}
//		p("isSafe() 2");
		return false;
	}
	
	public boolean _move(Set<CrossRiverThing> a,
			Set<CrossRiverThing> b,
			Set<CrossRiverThing> _boat, 
			boolean force) {
//		p("_move() 1");
//		print(a);
//		print(_boat);
//		p(a.containsAll(_boat));
//		p(_boat.equals(this.preBoat));
		
		if(!force) {
			if(!a.containsAll(_boat)) {
				return false;
			}
		}
//		p("_move() 2");
		a.removeAll(_boat);
		b.addAll(_boat);
		
		this.preBoat = _boat;
		if(bHistory.contains(b)) {
			return false;
		}
		
		return true;
	}
	
	public void move(Set<CrossRiverThing> x, Set<CrossRiverThing> y) {
		p(">>>>>>");
		if(this.b.containsAll(target)) {
			p("contians all");
			print(this.solution);
			p("--------------------");
		} else {
			for(Set<CrossRiverThing> _boat: this.boatOk) {
				p("------");
				p("_move()");
				p("x:");
				print(x);
				p("y:");
				print(y);
				p("_boat:");
				print(_boat);
				p("bHistory:");
				print(bHistory);
				p("------");
				boolean moved = _move(x, y, _boat, false);
				if(moved && isSafe()) {
					p("moved!!!!!!");
					print(_boat);
					this.solution.add(_boat);
					this.bHistory.add(b);
					move(y, x);
				}
				if(moved) {
//					p("moved restore!!!!!!");
					_move(y, x, _boat, true);
				}
			}
		}
	}
	
	public void print(Set<CrossRiverThing> s) {
		for(CrossRiverThing c: s) {
			d(c.toString() + " ");
		}
		p("");
	}
	
	public void print(List<Set<CrossRiverThing>> solution) {
		for(Set<CrossRiverThing> s: solution) {
			print(s);
		}
	}
	
	public static void demo() {
		CrossRiver cr = new CrossRiver();
		cr.move(cr.a, cr.b);
	}

	public static void main(String[] args) {
		demo();
	}

}
