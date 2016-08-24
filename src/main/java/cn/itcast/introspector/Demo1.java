package cn.itcast.introspector;

import org.junit.Test;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2016/8/19.
 */
public class Demo1 {
    @Test
    public void test1() throws Exception {
        BeanInfo info = Introspector.getBeanInfo(Person.class, Object.class);
        PropertyDescriptor[] dsp = info.getPropertyDescriptors();
        for (PropertyDescriptor d : dsp) {
            System.out.println(d.getName());
        }
    }

    @Test
    public void test2() throws Exception {
        Person p = new Person();
        PropertyDescriptor pd = new PropertyDescriptor("age", Person.class);
        Method method = pd.getWriteMethod();
        method.invoke(p, 233);


        Method method1 = pd.getReadMethod();
        System.out.println(method1.invoke(p, null));
    }

    @Test
    public void test3() throws Exception {
        Person p = new Person();
        PropertyDescriptor pd = new PropertyDescriptor("age", Person.class);

        System.out.println(pd.getPropertyType());

        Method method = pd.getWriteMethod();
        method.invoke(p, 233);

        Method method1 = pd.getReadMethod();
        System.out.println(method1.invoke(p, null));
    }

}
