package leetcode.string;

import java.util.Arrays;

import static d.M.*;
import static t.A.*;

/*
 * There are two sorted arrays A and B of size m and n respectively. 
 * Find the median of the two sorted arrays. 
 * The overall run time complexity should be O(log (m+n)).
 */

public class MedianOfTwoSortedArray {
	
//	public static int[] a = {-19, -18, -15, -11, -9, -7, -5, -4, -3, -2, -1, 0, 2, 3, 4, 5, 8, 9, 12, 15};
//	public static int[] b = {-20, -18, -17, -16, -11, -9, -8, -7, -5, -4, -3, 0, 4, 5, 9, 10, 14, 15, 16, 18};
	public static int[] a = {-5, -4, -2, 1, 4, 5};
	public static int[] b = {-5, -2, -1, 0, 3, 4};
	
	/*
	 * O(m+n)的算法，最直接，用来检查算法正确性
	 */
	public static int getMedian(int[] a, int[] b) {
		int[] res = merge(a, b);
		Arrays.sort(res);
		return res[res.length/2];
	}
	
	/*
	 * 考虑简单一些的情况， a.length == b.length
	 */
	public static int find_median_equal_length(int[] a, int[] b, int aStart, int aEnd, int bStart, int bEnd)  
	{  
	    if (aEnd == aStart)   
	        return a[aStart];     
	    
	    int aMid1, aMid2, bMid1, bMid2;      
	    int aLen = aEnd - aStart + 1;
	    if(aLen % 2 == 0) {
	    	aMid1 = aStart + aLen/2 -1;
	    	aMid2 = aStart + aLen/2;
	    } else {
	    	aMid1 = aMid2 = aStart + aLen/2;
	    }
	    int bLen = bEnd - bStart + 1;
	    if(bLen % 2 == 0) {
	    	bMid1 = bStart + bLen/2 -1;
	    	bMid2 = bStart + bLen/2;
	    } else {
	    	bMid1 = bMid2 = bStart + bLen/2;
	    }
	    
	    int aMidValue = (a[aMid1]+a[aMid2])/2;
	    int bMidValue = (b[bMid1]+b[bMid2])/2;
	    if (aMidValue==bMidValue)  
	        return aMidValue;  
	    else if (aMidValue<bMidValue)  
	        return find_median_equal_length(a, b, aMid2, aEnd, bStart, bMid1);  
	    else   
	        return find_median_equal_length(a, b, aStart, aMid1, bMid2, bEnd);  
	}  
	
	/*
	 * 复杂的情况，a.length != b.length
	 */
	public static double findMedianSortedArrays(int A[], int B[]) {
		int m = A.length;
		int n = B.length;
	 
		if ((m + n) % 2 != 0) // odd
			return (double) findKth(A, B, (m + n) / 2, 0, m - 1, 0, n - 1);
		else { // even
			return (findKth(A, B, (m + n) / 2, 0, m - 1, 0, n - 1) 
				+ findKth(A, B, (m + n) / 2 - 1, 0, m - 1, 0, n - 1)) * 0.5;
		}
	}
	 
	public static int findKth(int A[], int B[], int k, 
		int aStart, int aEnd, int bStart, int bEnd) {
	 
		int aLen = aEnd - aStart + 1;
		int bLen = bEnd - bStart + 1;
	 
		// Handle special cases
		if (aLen == 0)
			return B[bStart + k];
		if (bLen == 0)
			return A[aStart + k];
		if (k == 0)
			return A[aStart] < B[bStart] ? A[aStart] : B[bStart];
	 
		int aMid = aLen * k / (aLen + bLen); // a's middle count
		int bMid = k - aMid - 1; // b's middle count
	 
		// make aMid and bMid to be array index
		aMid = aMid + aStart;
		bMid = bMid + bStart;
	 
		if (A[aMid] > B[bMid]) {
			k = k - (bMid - bStart + 1);
			aEnd = aMid;
			bStart = bMid + 1;
		} else {
			k = k - (aMid - aStart + 1);
			bEnd = bMid;
			aStart = aMid + 1;
		}
	 
		return findKth(A, B, k, aStart, aEnd, bStart, bEnd);
	}

	public static void demo() {
		int[] c = merge(a, b);
		Arrays.sort(c);
		int index = 0;
		for(int i: c) {
			d(String.format("[%d]%d ", index++, i));
		}
		p("");
		
		p(getMedian(a, b));
		
		p(find_median_equal_length(a, b, 0, a.length-1, 0, b.length-1));
		
		p(findMedianSortedArrays(a, b));
	}
	
	public static void main(String[] args) {
		demo();
	}

}
