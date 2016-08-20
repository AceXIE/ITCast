package cn.itcast.reflect;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2016/8/19.
 */
public class Demo2 {
    @Test
    public void test1() throws Exception {
        Person p = new Person();

        Class clazz = Class.forName("cn.itcast.reflect.Person");
        Method method = clazz.getMethod("aa1", null);
        method.invoke(p, null);
    }

    @Test
    public void test2() throws Exception {
        Person p = new Person();

        Class clazz = Class.forName("cn.itcast.reflect.Person");
        Method method = clazz.getMethod("aa1", String.class, int[].class);
        Class[] cs = (Class[]) method.invoke(p, "Zhang", new int[]{1,2,3});
        System.out.println(cs[0]);
    }

    @Test
    public void test3() throws Exception {
        Person p = new Person();

        Class clazz = Class.forName("cn.itcast.reflect.Person");
        Method method = clazz.getDeclaredMethod("aa1", InputStream.class);
        method.setAccessible(true);
        method.invoke(p, new FileInputStream(""));
    }

    @Test
    public void test4() throws Exception {

        Class clazz = Class.forName("cn.itcast.reflect.Person");
        Method method = clazz.getMethod("aa1", int.class);
        method.invoke(null, 23);
    }

    @Test
    public void test5() throws Exception {

        Class clazz = Class.forName("cn.itcast.reflect.Person");
        Method method = clazz.getMethod("main", String[].class);
        method.invoke(null, (Object)new String[]{"a","b"});

    }

}
