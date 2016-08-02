/**
 * 
 */
package d;
import static kemin.util.Pr.*;
//import static kemin.util.PrVoid.*;

/**
 * @author user
 *
 */
public class M {
	public static void p(String s) {
		println(s);
	}
	public static void p(boolean b) {
		println(b);
	}
	public static void p(byte b) {
		println(b);
	}
	public static void p(char c) {
		println(c);
	}
	public static void p(double d) {
		println(d);
	}
	public static void p(float f) {
		println(f);
	}
	public static void p(int i) {
		println(i);
	}
	public static void p(long l) {
		println(l);
	}
	public static void p(short s) {
		println(s);
	}
	public static void p(Object o) {
		println(o);
	}
	
	public static void d(String s) {
		printnb(s);
	}
	public static void d(boolean b) {
		printnb(b);
	}
	public static void d(byte b) {
		printnb(b);
	}
	public static void d(char c) {
		printnb(c);
	}
	public static void d(double d) {
		printnb(d);
	}
	public static void d(float f) {
		printnb(f);
	}
	public static void d(int i) {
		printnb(i);
	}
	public static void d(long l) {
		printnb(l);
	}
	public static void d(short s) {
		printnb(s);
	}
	public static void d(Object o) {
		printnb(o);
	}
	
	public static String getTrace(){
        StringBuffer sb = new StringBuffer();  
         
        StackTraceElement[] stacks = new Throwable().getStackTrace();
        int stacksLen = stacks.length;
        sb.append("class: " ).append(stacks[1].getClassName()).append("; method: ")
          .append(stacks[1].getMethodName()).append("; number: ")
          .append(stacks[1].getLineNumber()).append("; ... ");
        
        return sb.toString();
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		p("Michael is Kemin");
//		String _methodName = new Exception().getStackTrace()[1].getMethodName();// 锟斤拷玫锟斤拷锟斤拷叩姆锟斤拷锟斤拷锟�
//		debug(_methodName);
		String _thisMethodName =  new Exception().getStackTrace()[0].getMethodName();// 锟斤拷玫锟角帮拷姆锟斤拷锟斤拷锟�?
		p(_thisMethodName);
		p(getTrace());
	}

}


