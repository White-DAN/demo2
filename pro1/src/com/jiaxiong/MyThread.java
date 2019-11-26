package com.jiaxiong;

/**
 * @Author: jiaxiong
 * @Date: 2019/7/18 13:36
 * @Version 1.8.0_131
 **/

public class MyThread extends Thread{

    public static void main(String[] args) {
        //测试两种创建线程的方法
//        SubThread td1 = new SubThread();
//        td1.start();
//
//        Runnable rb = new RunnableThread();           //创建，并初始化RunnableThread对象rb
//        Thread  td = new Thread(rb);              //通过Thread创建线程对象td
//        td.start();                             //启动线程

        //测试两种等待线程结束并执行另外一个线程的方法
        MyThread test = new MyThread();
        test.method1();
       // test.method2();
    }
    //第一种等待线程结束并执行另一个线程的方法
    public void method1(){
        SubThread st1 = new SubThread();
        SubThread st2 = new SubThread();
        //执行第一个线程
        st1.start();
        //查询第一个线程的状态
        while (st1.isAlive()){
            try {
                Thread.sleep(100);      //主线程休眠100毫秒
            }catch (InterruptedException e){
                e.printStackTrace();           //异常信息输出
            }
        }
        //第一个线程结束后，运行第二个线程
        st2.start();
    }
    //第二种等待线程结束并执行另一个线程的方法
    public void method2(){
        SubThread st1 = new SubThread();
        SubThread st2 = new SubThread();
        //执行第一个线程
        st1.start();
        //查询第一个线程的状态
        while (st1.isAlive()){
            try {
                st1.join();      //st1调用join方法,等待该线程终止
            }catch (InterruptedException e){
                e.printStackTrace();           //异常信息输出
            }
        }
        //第一个线程结束后，运行第二个线程
        st2.start();
    }
}
//使用Thread创建线程
class SubThread extends Thread{
    //声明无参数，空构造方法
    SubThread(){;}
    //声明带有字符串参数的构造方法
    SubThread(String name){
        super(name);
    }
    //重载run函数
    public void run(){
        for (int count=1,row=1; row<10; row++,count++){
            for (int i=0; i<count; i++){
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println("SubThread启动");
    }
}

//使用Runnable接口创建线程
class RunnableThread implements Runnable{
    //重载run函数
    public void run(){
        for (int count=1,row=1; row<10; row++,count++){
            for (int i=0; i<count; i++){
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println("RunnableThread启动");
    }
}
