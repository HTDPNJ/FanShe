package com.hfut.pojo;

public class Student extends Person {
    public String sname="张三";
    protected int sage;
    String sfav;
    private String ssex="男";
    public static int money=100;

    public Student() {
    }
    public String sHi(){
        return "hi reflect";
    }
    public String sHi(int num,String str){
        System.out.println(str+num);
        return str+num;
    }
    public static String sHi(String str){
        System.out.println(str);
        return str;
    }
    protected  void sHello1(){
        System.out.println("student.shello()");
    }
    void sHello(){
        System.out.println("Student.shello2");
    }
}
