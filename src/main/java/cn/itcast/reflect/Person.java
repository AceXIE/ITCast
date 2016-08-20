package cn.itcast.reflect;

import java.io.InputStream;
import java.util.List;

/**
 * Created by Administrator on 2016/8/19.
 */
public class Person {
    public String name = "xiekai";
    private int password = 123;
    public static int anInt = 2333;

    public Person() {
        System.out.println("person");
    }
    public Person(String name) {
        System.out.println(name);
    }
    public Person(String name, int password) {
        System.out.println(name + "," + password);
    }
    private Person(List list) {
        System.out.println("Person list");
    }

    public void aa1() {
        System.out.println("aa1");
    }
    public void aa1(String name) {
        System.out.println("String" + name);
    }

    public Class[] aa1(String name, int[] password) {
        return new Class[]{String.class};
    }

    private void aa1(InputStream in) {
        System.out.println(in);
    }

    public static void aa1(int num) {
        System.out.println(num);
    }

    public static void main(String[] args) {
        System.out.println("..Main..");
    }

}
