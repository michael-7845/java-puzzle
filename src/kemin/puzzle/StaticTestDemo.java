package kemin.puzzle;

/*
 * 背景知识
Java中赋值顺序： 
1. 父类的静态变量赋值 
2. 自身的静态变量赋值 
3. 父类成员变量赋值 
4. 父类块赋值 
5. 父类构造函数赋值 
6. 自身成员变量赋值 
7. 自身块赋值 
8. 自身构造函数赋值
 *冷知识，在嵌套初始化时有一个特别的逻辑。特别是内嵌的这个变量恰好是个静态成员，而且是本类的实例。
这会导致一个有趣的现象：“实例初始化竟然出现在静态初始化之前”。
其实并没有提前，你要知道java记录初始化与否的时机。
 */

public class StaticTestDemo {

	public static void main(String[] args)
    {
        staticFunction();
    }
 
    static StaticTestDemo st = new StaticTestDemo();
 
    static
    {
        System.out.println("1");
    }
 
    {
        System.out.println("2");
    }
 
    StaticTestDemo()
    {
        System.out.println("3");
        System.out.println("a="+a+",b="+b);
    }
 
    public static void staticFunction(){
        System.out.println("4");
    }
 
    int a=110;
    static int b =112;
    
    /*
     * answer:
     * 2 => main()会需要类的载入， main方法的调用触发静态初始化
     * 类的生命周期是：加载->验证->准备->解析->初始化->使用->卸载，只有在准备阶段和初始化阶段才会涉及类变量的初始化和赋值
     * 最开始执行到静态变量赋值：static StaticTestDemo st = new StaticTestDemo(); 
     * 执行构造函数的逻辑， 先初始化成员变量(打印2， a赋值；静态成员b在后面的静态赋值中才会赋值)， 再执行构造函数
     * 3
     * a=110, b=0
     * 1 => 继续进行静态变量赋值（按顺序进行静态块， 先打印1，再b赋值）
     * 4 => staticFunction(); 打印4
     */
}
