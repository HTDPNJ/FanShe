package com.hfut.pojo;

public class Person {
    public String pname="张三";
    protected int page;
    String pfav;
    private String psex;

    public Person() {
    }

    public Person(String pname) {
        this.pname = pname;
    }

    public String psHi(){
        return "hi reflect";
    }
    public String psHi(int num,String str){
        return str+num;
    }
    protected  void psHello1(){
        System.out.println("student.shello(protected)");
    }
    void psHello(){
        System.out.println("Student.shello2(default)");
    }
}
