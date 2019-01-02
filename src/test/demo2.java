package test;

import javax.sound.midi.Soundbank;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @program: sort
 * @Date: 2018/10/11 19:09
 * @Author: Mr.Li
 * @Description:
 */
public class demo2 {
    public static void main(String[] args) {
        function();
    }
    private static void function(){
        HashMap<Integer,String> his=new HashMap<>(50);
        his.put(1,"a");
        his.put(2,"b");
        his.put(3,"c");
        System.out.println(his);
        Set<Integer> s=his.keySet();
        Iterator<Integer> i=s.iterator();
        while (i.hasNext()){
            Integer key=i.next();
            String value=his.get(key);
            System.out.println(key+"-----"+value);
        }

        for (Integer j:his.keySet()){
            System.out.print(his.get(j)+"\t");
        }
        System.out.println();
        for (Map.Entry<Integer,String> map:his.entrySet()){
            System.out.println(map.getKey()+"........."+map.getValue());
        }
    }



}
