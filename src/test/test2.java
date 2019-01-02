package test;

/**
 * @program: sort
 * @Date: 2018/10/14 23:09
 * @Author: Mr.Li
 * @Description:
 */
class Super {
    public Integer getLenght() { return new Integer(4); }
}

public class test2 extends Super {
    public Integer getLenght() { return new Long(5).intValue(); }
    public static void main(String[] args) {
        Super sooper = new Super();
        test2 sub = new test2();
        System.out.println(sooper.getLenght().toString() + "," +
                sub.getLenght().toString() );
    }


}
