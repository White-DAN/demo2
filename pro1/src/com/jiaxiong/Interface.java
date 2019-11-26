package com.jiaxiong;

/**
 * @Author: jiaxiong
 * @Date: 2019/7/11 21:31
 * @Version 1.8.0_131
 **/

//接口定义
interface Animal{
    int BIG_TYPE = 5;
    void sleep();
    void eat();
    void breath();
}
//子接口
interface Mammal extends Animal{
    void run();
}

//定义类实现这两个接口
class Tiger implements Mammal{
    String name;
    public Tiger(String nm){
        name = nm;
    }
    //实现子接口必须实现子接口以及父接口所有方法
    public void breath(){
        System.out.println(name+"The Tiger breath");
    }
    public void eat(){
        System.out.println(name +"The Tiger eat");
    }
    public void sleep(){
        System.out.println(name +"The Tiger sleep");
    }
    public void run(){
        System.out.println(name +"The Tiger run");
    }
}

class Fish implements Animal{
    String name;
    public Fish(String nm){
        name = nm;
    }
    //实现子接口必须实现子接口以及父接口所有方法
    public void breath(){
        System.out.println(name+"用腮呼吸");
    }
    public void eat(){
        System.out.println(name +"在吃水草");
    }
    public void sleep(){
        System.out.println(name +"在睁着眼睛睡觉");
    }
}

//主程序
public class Interface {
    public static void main(String[] args) {
        //Animal接口，Fish对象
        Animal fish = new Fish("鲨鱼");
        //Animal接口，Tiger对象
        Animal tiger1 = new Tiger("东北虎");
        //Mammal接口，Tiger对象
        Mammal tiger2 = new Tiger("华南虎");
        //调用fish各种方法
        fish.breath();
        fish.eat();
        fish.sleep();
        //调用tiger1各种方法
        tiger1.sleep();
        tiger1.eat();
        tiger1.breath();
        //调用tiger1 run方法，需要进行类型转换
        ((Tiger)tiger1).run();
        //调用tiger2各种方法
        tiger2.breath();
        tiger2.eat();
        tiger2.sleep();
        tiger2.run();       //不需要进行类型转换

        //
        Time t = new Time();
        t.print();
    }
}

//用接口创建常量组
interface WeekDays{
    int MONDAY = 1;
    int TUESDAY = 2;
    int WEDNESDAYS = 3;
    int THURSDAY = 4;
    int FRIDAY = 5;
    int SATURDAY = 6;
    int SUNDAY = 7;
}
class Time implements WeekDays{
    void print(){
        System.out.println("MONDAY = " + MONDAY);
        System.out.println("TUESDAY = " + TUESDAY);
        System.out.println("WEDNESDAYS = " + WEDNESDAYS);
        System.out.println("THURSDAY = " + THURSDAY);
        System.out.println("FRIDAY = " + FRIDAY);
        System.out.println("SATURDAY = " + SATURDAY);
        System.out.println("SUNDAY = " + SUNDAY);
    }
}