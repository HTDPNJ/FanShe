package com.hfut.testReflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestReflect {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        //反射操作类属性
       // operField();
        //操作字段值
       // oper();
        operMethod();


}
    public static void operMethod() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Class cla=Class.forName("com.hfut.pojo.Student");
        Method[]ms=cla.getMethods();
        for(Method m:ms){
            System.out.println("获取方法名："+m.getName());
        }

        System.out.println("获取指定的公共方法");
        Method m=cla.getMethod("sHi",int.class,String.class);
        System.out.println(m.getName());

        System.out.println("获取指定的声明的方法，不包括父类");
        Method m2=cla.getDeclaredMethod("sHello",null);
        System.out.println(m2.getName());
        ///执行方法
        //静态方法
        System.out.println("***调用方法*");
        Method m3=cla.getDeclaredMethod("sHi", String.class);
        m3.invoke(null,"天气真好");

        //非静态方法
        Method m4= cla.getDeclaredMethod("sHi", int.class, String.class);
        m4.invoke(cla.newInstance(),3,"hhhh");


    }
    public static void oper() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException {
        Class cla=Class.forName("com.hfut.pojo.Student");

        System.out.println("---操作静态字段---");
        Field fs=cla.getDeclaredField("money");
        System.out.println(fs.get(null)); //获取静态变量
        fs.set(null,2000);//设置值
        System.out.println(fs.get(null));


        System.out.println("******操作非静态字段****");
        Field fd=cla.getDeclaredField("sname");
        Object obj=cla.newInstance();
        System.out.println(fd.get(obj));
        fd.set(obj,"张小三");
        System.out.println(fd.get(obj));

        System.out.println("**暴力反射操作私有化属性**");
        Field fd2=cla.getDeclaredField("ssex");
        Object obj2=cla.newInstance();
        fd2.setAccessible(true);
        System.out.println(fd2.get(obj2));
    }
    public static void operField() throws ClassNotFoundException, NoSuchFieldException {
        //获取类对象
        Class cla=Class.forName("com.hfut.pojo.Student");
        //获取该类的公共字段
        Field[] fds=cla.getFields();
        for(Field f:fds){
            System.out.println(f.getName());
            System.out.println(f.getModifiers());
            System.out.println(f.getType());
        }
        //获取该类申明的所有字段
        Field[]fds2=cla.getDeclaredFields();
        for(Field f:fds2){
            System.out.println("----"+f.getName());
        }
        //获取指定的字段
        Field f=cla.getField("pname"); //只能获取公共的
        System.out.println(f.getName());

    }
}
