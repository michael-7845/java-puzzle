package kemin.puzzle;

/*
 * ����֪ʶ
Java�и�ֵ˳�� 
1. ����ľ�̬������ֵ 
2. ����ľ�̬������ֵ 
3. �����Ա������ֵ 
4. ����鸳ֵ 
5. ���๹�캯����ֵ 
6. �����Ա������ֵ 
7. ����鸳ֵ 
8. �����캯����ֵ
 *��֪ʶ����Ƕ�׳�ʼ��ʱ��һ���ر���߼����ر�����Ƕ���������ǡ���Ǹ���̬��Ա�������Ǳ����ʵ����
��ᵼ��һ����Ȥ�����󣺡�ʵ����ʼ����Ȼ�����ھ�̬��ʼ��֮ǰ����
��ʵ��û����ǰ����Ҫ֪��java��¼��ʼ������ʱ����
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
     * 2 => main()����Ҫ������룬 main�����ĵ��ô�����̬��ʼ��
     * ������������ǣ�����->��֤->׼��->����->��ʼ��->ʹ��->ж�أ�ֻ����׼���׶κͳ�ʼ���׶βŻ��漰������ĳ�ʼ���͸�ֵ
     * �ʼִ�е���̬������ֵ��static StaticTestDemo st = new StaticTestDemo(); 
     * ִ�й��캯�����߼��� �ȳ�ʼ����Ա����(��ӡ2�� a��ֵ����̬��Աb�ں���ľ�̬��ֵ�вŻḳֵ)�� ��ִ�й��캯��
     * 3
     * a=110, b=0
     * 1 => �������о�̬������ֵ����˳����о�̬�飬 �ȴ�ӡ1����b��ֵ��
     * 4 => staticFunction(); ��ӡ4
     */
}
