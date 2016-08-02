package kemin.puzzle;

import static d.M.*;

/*
 * 著名的8皇后问题，不再重复。
 */
public class Queens {
	
	private int n ; //皇后个数  
    private int[] x ; //当前解  
    private long sum ; //当前已找到的可行方案数  
    private static int h ;      //记录遍历方案序数  
  
    public Queens(){  
        this.sum = 0 ;  //初始化方案数为1，当回溯到最佳方案的时候，就自增1  
        this.n = 5 ;    //求n皇后问题，由自己定义  
        this.x = new int[n+1];  //x[i]表示皇后i放在棋盘的第i行的第x[i]列  
        h = 1 ; //这个是我额外定义的变量，用于遍历方案的个数，请看backTrace()中h变量的作用，这里将它定义为static静态变量  
    }  
    
    public boolean place(int c) {
    	for(int i=1; i<c; i++) {
    		if(Math.abs(c-i)==Math.abs(x[c]-x[i]) || x[c]==x[i]) { //斜线 或者 相同列
    			return false;
    		}
    	}
    	return true;
    }

    public void backtrace(int t) {
    	if(t>n) {
    		sum++ ;    //方案数自增1  
            p("solution " + (h++) + ": ");  
            print(x); 
            display(x);
            p("----------------");  
    	} else {
    		for(int i=1; i<=n; i++) {
    			x[t] = i;
    			if(place(t)) {
    				backtrace(t+1);
    			}
    		}
    	}
    }
    
	public void print(int[] a){
        for (int i = 1 ; i < a.length ; i++){  
            p("Quene " + i + " @ row: " + i + ", column: " +a[i] );  
        }  
    }
	
	public void display(int[] a) {
		String fd = "%3d";
		String fs = "%3s";
		
		for(int i=0; i<a.length; i++) {
			d(String.format(fd, i));
		}
		p("");
		
		int rowNum = 1;
		for(int row=1; row<a.length; row++) {
			d(String.format(fd, rowNum));
			rowNum++;
			for(int column=1; column<a.length; column++) {
				if(a[row] == column) {
					d(String.format(fs, "Q"));
				} else {
					d(String.format(fs, "X"));
				}
			}
			p("");
		}
	}
	
	public static void demo() {
		Queens q = new Queens();
		q.backtrace(1);
	}
	
	public static void demo2() {
		int[] a = {1, 2, 3, 4, 5};
		(new Queens()).display(a);
	}

	public static void main(String[] args) {
		demo();
	}

}
