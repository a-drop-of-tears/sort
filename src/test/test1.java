package test;

/**
 * @program: sort
 * @Date: 2018/10/14 15:26
 * @Author: Mr.Li
 * @Description:
 */
public class test1 {
    public static void main(String[] args) {
        Resource r=new Resource();
        Input in=new Input(r);
        Output out=new Output(r);
        Thread tin=new Thread(in);
        Thread tout=new Thread(out);
        tin.start();
        tout.start();
    }
}
