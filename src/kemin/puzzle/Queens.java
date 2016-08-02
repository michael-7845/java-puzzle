package kemin.puzzle;

import static d.M.*;

/*
 * ������8�ʺ����⣬�����ظ���
 */
public class Queens {
	
	private int n ; //�ʺ����  
    private int[] x ; //��ǰ��  
    private long sum ; //��ǰ���ҵ��Ŀ��з�����  
    private static int h ;      //��¼������������  
  
    public Queens(){  
        this.sum = 0 ;  //��ʼ��������Ϊ1�������ݵ���ѷ�����ʱ�򣬾�����1  
        this.n = 5 ;    //��n�ʺ����⣬���Լ�����  
        this.x = new int[n+1];  //x[i]��ʾ�ʺ�i�������̵ĵ�i�еĵ�x[i]��  
        h = 1 ; //������Ҷ��ⶨ��ı��������ڱ��������ĸ������뿴backTrace()��h���������ã����ｫ������Ϊstatic��̬����  
    }  
    
    public boolean place(int c) {
    	for(int i=1; i<c; i++) {
    		if(Math.abs(c-i)==Math.abs(x[c]-x[i]) || x[c]==x[i]) { //б�� ���� ��ͬ��
    			return false;
    		}
    	}
    	return true;
    }

    public void backtrace(int t) {
    	if(t>n) {
    		sum++ ;    //����������1  
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
