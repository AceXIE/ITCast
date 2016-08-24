package cn.itcast.beanutils;


import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/8/19.
 */
public class Demo1 {

    @Test
    public void test1() throws InvocationTargetException, IllegalAccessException {
        Person p = new Person();
        BeanUtils.setProperty(p, "name", "hehe");
        System.out.println(p.getName());
    }

    @Test
    public void test2() throws InvocationTargetException, IllegalAccessException {
        Person p = new Person();
        String name = "test2";
        String password = "233";
        String age = "24";
        String birthday = "";//!!!!!!!!!

        //注册转换器
        ConvertUtils.register(new Converter() {
            public Object convert(Class aClass, Object o) {
                if (o == null)
                    return null;
                if (!(o instanceof String)) {
                    throw new ConversionException("不是String, 只支持String");
                }
                String str = (String)o;
                if (str.trim().equals("")) {
                    return null;
                }
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    return df.parse(str);
                } catch (ParseException e) {
                    throw new RuntimeException(e);//异常链不能掉
                }

            }
        }, Date.class);

        BeanUtils.setProperty(p, "name", name);
        BeanUtils.setProperty(p, "password", password);
        BeanUtils.setProperty(p, "age", age);
        BeanUtils.setProperty(p, "birthday", birthday);

        System.out.println(p.getName());
        System.out.println(p.getPassword());
        System.out.println(p.getAge());
        System.out.println(p.getBirthday());

    }

    @Test
    public void test3() throws InvocationTargetException, IllegalAccessException {
        Person p = new Person();
        String name = "test3";
        String password = "233";
        String age = "24";
        String birthday = "";

        //注册转换器
        ConvertUtils.register(new DateLocaleConverter(), Date.class);


        BeanUtils.setProperty(p, "name", name);
        BeanUtils.setProperty(p, "password", password);
        BeanUtils.setProperty(p, "age", age);
        BeanUtils.setProperty(p, "birthday", birthday);

        System.out.println(p.getName());
        System.out.println(p.getPassword());
        System.out.println(p.getAge());
        System.out.println(p.getBirthday());

    }

    @Test
    public void test4() throws InvocationTargetException, IllegalAccessException {
        Map map = new HashMap();
        map.put("name", "name");
        map.put("password", "password");
        map.put("age", "age");
        map.put("birthday", "1991-11-11");


        ConvertUtils.register(new DateLocaleConverter(), Date.class);

        Person p = new Person();
        BeanUtils.populate(p, map);

        System.out.println(p.getName());
        System.out.println(p.getPassword());
        System.out.println(p.getAge());
        System.out.println(p.getBirthday());
    }

}
