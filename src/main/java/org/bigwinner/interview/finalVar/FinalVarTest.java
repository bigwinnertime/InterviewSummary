package org.bigwinner.interview.finalVar;

/**
 * @author: bigwinner
 * @date: 2021/5/14 上午9:24
 * @version: 1.0.0
 * @description: Final变量
 */
public class FinalVarTest {
    /**
     * 1. 这里注意有一个很普遍的误区。很多人会认为static修饰的final常量必须在声明时就进行初始化，否则会报错。
     *    但其实则不然，我们可以先使用static final关键字声明一个类常量，然后再在静态块内初始化空的final静态变量。
     * 2. final变量定义的时候，可以先声明，而不给初值，这中变量也称为final空白，无论什么情况，编译器都确保空白final在使用之前必须被初始化。
     *    但是，final空白在final关键字final的使用上提供了更大的灵活性，为此，一个类中的final数据成员就可以实现依对象而有所不同，却又有保持其恒定不变的特征。
     */
    static final String a;
    static  {a = "test";}

    final int num;
    {num = 11;}

    /** 空白final */
    final String b;
    FinalVarTest(){
        b = "11111";
        System.out.println("构造函数");
        System.out.println(b);
    }

    FinalVarTest(String word) {
        b = word;
        System.out.println(b);
    }

    public final void test() {}
    private final void test1() {}

    public static void main(String[] args) {
        FinalVarTest finalVarTest = new FinalVarTest("cccc");
        System.out.println(finalVarTest.b);
        System.out.println(a);
        System.out.println("-------分割线------");
//        System.out.println(finalVarTest.num);
    }
}
class Sub extends FinalVarTest
{
    // 下面方法定义将出现编译错误，不能重写final方法
//    public void test(){}
    // 下面方法定义将不会出现问题
    public void test1(){}

}
