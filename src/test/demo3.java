package test;

/**
 * @program: sort
 * @Date: 2018/10/11 19:45
 * @Author: Mr.Li
 * @Description:
 */
class Example1 {
    public String name(){
        return "liutao";
    }
}
class Example2{
    public int age(){
        return 25;
    }
}
public class demo3{
    private class test1 extends Example1{
        @Override
        public String name(){
            return super.name();
        }
    }
    private class test2 extends Example2{
        @Override
        public int age(){
            return super.age();
        }
    }

    public String name(){
        return new test1().name();
    }

    public int age(){
        return new test2().age();
    }

    public static void main(String[] args) {
        demo3 d=new demo3();
        System.out.println("姓名："+d.name());
        System.out.println("年龄："+d.age());
    }

}



