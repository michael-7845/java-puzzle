package kemin.coding;

import static d.M.*;

public class PurePower {
	
	public static double power(int a, int b) {
		if(b == 0) return 1.0;
		int pow = (b>0) ? b : -b; 
		double result = 1.0, base = a;
		while(pow!=0) {
			if((pow&1) == 1) {
				result *= base;
			}
			base *= base;
			pow >>= 1;
		}
		return b>0 ? result : 1.0/result;
	}
	
	public static double power2(int a, int b) {
		if(b == 0) return 1.0;
		int pow = (b>0) ? b : -b;
		double result = 1.0, base = a;
		while(pow != 0) {
//			if((pow%2) == 1) {
			if((pow - 2*(pow/2)) == 1) {
				result *= base;
			}
			base *= base;
			pow /= 2;
		}
		return b>0 ? result : 1.0/result;
	}
	
	public static void demo() {
		p(power(2,1));
		p(power(2,2));
		p(power(2,3));
		p(power(2,0));
		p(power(2,10));
		p(power(2,-1));
		p(power(2,-2));
		p(power(2,-3));
	}
	
	public static void demo2() {
		p(power2(2,1));
		p(power2(2,2));
		p(power2(2,3));
		p(power2(2,0));
		p(power2(2,10));
		p(power2(2,-1));
		p(power2(2,-2));
		p(power2(2,-3));
	}

	public static void main(String[] args) {
		demo2();
	}

}
