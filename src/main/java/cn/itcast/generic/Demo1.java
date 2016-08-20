package cn.itcast.generic;

import org.junit.Test;

import java.util.*;

/**
 * Created by Administrator on 2016/8/20.
 */
public class Demo1 {
    @Test
    public void test1() {
        List<String> list1 = new ArrayList<String>();
        list1.add("aaa");

        Iterator<String> it = list1.iterator();
        while (it.hasNext()) {
            System.out.print(it.next());
        }
    }

    @Test
    public void test2() {
        Map<Integer, String> map = new HashMap<Integer, String>();

        Set<Map.Entry<Integer, String>> set = map.entrySet();
        Iterator<Map.Entry<Integer, String>> it = set.iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, String> entry = it.next();
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }

}
