package cn.itcast.reflect;

import org.junit.Test;

import java.lang.reflect.Field;

/**
 * Created by Administrator on 2016/8/19.
 */
public class Demo3 {
    @Test
    public void test1() throws Exception {
        Person p = new Person();

        Class clazz = Class.forName("cn.itcast.reflect.Person");
        Field field = clazz.getField("name");

        Object obj = field.get(p);

        Class type = field.getType();

        if (type.equals(String.class)) {
            String name = (String) obj;
            System.out.println(name);
        }

        field.set(p, "aaaa");
        System.out.println(p.name);
    }

    @Test
    public void test2() throws Exception {
        Person p = new Person();

        Class clazz = Class.forName("cn.itcast.reflect.Person");
        Field field = clazz.getDeclaredField("password");
        field.setAccessible(true);
        System.out.println(field.get(p));
    }
}
