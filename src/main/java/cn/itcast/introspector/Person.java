package cn.itcast.introspector;

/**
 * Created by Administrator on 2016/8/19.
 */
public class Person {//javaBean

    private String name;
    private String password;
    private int age;

    public String getAB() {
        return null;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
