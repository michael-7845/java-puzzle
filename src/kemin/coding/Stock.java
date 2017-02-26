package kemin.coding;

import static d.M.*;

import java.util.Arrays;

/**
 * 假设一个数组，其第i个元素是一支规定股票的某一天的价格。
 * 问题1：如果最多只允许完成一次交易（例如，购买或销售一次该股票的份额），设计一个算法，找到最大的赢利点。
 * 问题2：可以进行任意多次交易（例如，多次购买或销售该股票的份额），然而不能同时进行多次交易（例如，在再次购买之前，必须先销售该股票），设计一个算法，找到最大的赢利点。
 * 问题2.b：进行尽量少次数的交易，然而不能同时进行多次交易（例如，在再次购买之前，必须先销售该股票），设计一个算法，找到最大的赢利点。
 * 问题3：可以进行两次交易，然而不能同时进行多次交易（例如，在再次购买之前，必须先销售该股票），设计一个算法，找到最大的赢利点。
 * 
 * @author Administrator
 *
 */

public class Stock {
	
	static int[] array = {38, 1, 2, 35, 5, 9, 11, 13, 15, 16, 17, 18, 19, 37, 22, 23, 24, 25, 28, 29, 8};
	
	public static void demo1(int[] stocks) {
		int minPrice=Integer.MAX_VALUE, 
			dayBuy=-1,
			maxProfit=Integer.MIN_VALUE,
			daySell=-1;
		for(int i=0;i<stocks.length;i++) {
			int cur = stocks[i];
			int profit = cur-minPrice;
			if(profit>maxProfit) {
				maxProfit = profit;
				daySell=i;
			}
			if(cur<minPrice) {
				minPrice = cur;
				dayBuy=i;
			}
		}
		
		p(String.format("day to buy: %d, day to sell: %d, min price: %d, max profit: %d", 
				dayBuy, daySell, minPrice, maxProfit));
	}
	
	//max profit
	public static int demo2(int[] stocks) {
		int totalProfit=0;
		if(stocks.length<=1) {
			return 0;
		}
		for(int i=1;i<stocks.length;i++) {
			int profit = stocks[i]-stocks[i-1];
			if(profit>0) {
				totalProfit += profit;
			}
		}
		p(totalProfit);
		return totalProfit;
	}
	
	public static void demo2b(int[] stocks) {
		int totalProfit=0,
			minDay = -1,
			maxDay = -1;
		for(int i=1;i<stocks.length;i++) {
			int profit = stocks[i]-stocks[i-1];
			if(profit>0) {
				totalProfit += profit;
				if(minDay == -1) minDay = i-1;
				if(maxDay == -1) maxDay = i;
				if(maxDay == i-1) maxDay = i;
				if(i == array.length-1) {
					p(String.format("day to buy: %d(price - %d), day to sell: %d(price - %d), profit: %d", 
							minDay, stocks[minDay], 
							maxDay, stocks[maxDay],
							stocks[maxDay]-stocks[minDay]));
				}
			} else {
				if(minDay != -1) {
					p(String.format("day to buy: %d(price - %d), day to sell: %d(price - %d), profit: %d", 
							minDay, stocks[minDay], 
							maxDay, stocks[maxDay],
							stocks[maxDay]-stocks[minDay]));
				}
				minDay = -1;
				maxDay = -1;
			}
		}
		p(totalProfit);
	}
	
	public static int maxProfit(int[] stocks) {
		int minPrice=Integer.MAX_VALUE, 
			maxProfit=Integer.MIN_VALUE;
		for(int i=0;i<stocks.length;i++) {
			int cur = stocks[i]; 
			int profit = cur-minPrice;
			if(profit>maxProfit) {
				maxProfit = profit;
			}
			if(cur<minPrice) {
				minPrice = cur;
			}
		}
		
		return maxProfit;
	}
	
	public static void demo3(int[] stocks) {
		int[] left= new int[stocks.length], 
			right = new int[stocks.length];
		for(int i=0; i<stocks.length; i++) {
			int[] leftArray = Arrays.copyOfRange(stocks, 0, i+1);
			int[] rightArray = Arrays.copyOfRange(stocks, i+1, stocks.length);
			left[i] = maxProfit(leftArray);
			right[i] = maxProfit(rightArray);
		}
		_print(left);
		_print(right);
		
		int maxProfit = Integer.MIN_VALUE;
		for(int i=1; i<stocks.length-1; i++) {
			int profit = left[i] + right[i];
			if(profit>maxProfit) {
				maxProfit = profit;
			}
		}
		p("maxProfit: " + maxProfit);
	}
	
	public static void _print(int[] a) {
		int index=0;
		for(int i: a) {
			d(String.format("[%d]%d", index++, i));
		}
		p("");
	}

	public static void main(String[] args) {
//		demo1(array);
//		demo2(array);
		demo2b(array);
//		demo3(array);
	}

}
