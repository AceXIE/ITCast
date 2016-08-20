package cn.itcast.generic;

/**
 * Created by Administrator on 2016/8/20.
 */
public class Demo3 <T> {

    public void a(T t) {

    }
    public static <T> void mm(T t) {

    }

    public void swap(T[] ts, int l, int r) {
        T tmp = ts[l];
        ts[l] = ts[r];
        ts[r] = tmp;
    }

    public void reverse(T[] ts) {
        int l = 0, r = ts.length - 1;
        while (l < r) {
            swap(ts, l, r);
            l++;r--;
        }
    }
}
