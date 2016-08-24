package cn.itcast.generic;

/**
 * Created by Administrator on 2016/8/20.
 */

//自定义泛型
public class Demo2 {

    public void test1() {
        a("aaa");
        a(1);
    }

    public <T> T a(T t) {
        return t;
    }

    public <K, V> void b(K k, V v) {

    }
}
