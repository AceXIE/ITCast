package cn.itcast.reflect;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/19.
 */
public class Demo1 {
    public static void main(String[] args) throws Exception {
        //记载类
        Class clazz = Class.forName("cn.itcast.reflect.Person");

//        Class clazz1 = new Person().getClass();
//
//        Class clazz2 = Person.class;

        //解剖类
        Constructor c = clazz.getConstructor(null);
        Person p = (Person) c.newInstance(null);
        System.out.println(p.name);
    }

    @Test
    public void test2() throws Exception {
        Class clazz = Class.forName("cn.itcast.reflect.Person");

        Constructor c = clazz.getConstructor(String.class);
        Person p = (Person) c.newInstance("XieKai");
    }

    @Test
    public void test3() throws  Exception {
        Class clazz = Class.forName("cn.itcast.reflect.Person");
        Constructor c = clazz.getConstructor(String.class, int.class);
        Person p = (Person) c.newInstance("XieKai", 24);
    }

    @Test
    public void test4() throws Exception {
        Class clazz = Class.forName("cn.itcast.reflect.Person");
        Constructor c = clazz.getDeclaredConstructor(List.class);
        c.setAccessible(true);//暴力反射
        Person p = (Person) c.newInstance(new ArrayList());

    }

    @Test
    public void test5() throws Exception {
        Class clazz = Class.forName("cn.itcast.reflect.Person");
        Person p = (Person) clazz.newInstance();


    }
}
