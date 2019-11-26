package com.jiaxiong;

/**
 * @Author: jiaxiong
 * @Date: 2019/7/18 15:12
 * @Version 1.8.0_131
 **/

//线程同步
public class ThreadSynchronized {
    public static void main(String[] args) {
        ShareData sData = new ShareData();
        //创建线程
        SubThread1 st1 = new SubThread1("Thread1", sData);
        SubThread1 st2 = new SubThread1("Thread2", sData);
        st1.start();
        st2.start();
    }
}

class ShareData{
    public static String Data  = "";        //声明并初始化字符串数据域
}
//Thread创建线程
class SubThread1 extends Thread{
    private ShareData sData;
    SubThread1(){}                              //声明，实现无参数构造方法
    SubThread1(String name, ShareData sData){   //声明，实现带参数构造方法
        super(name);
        this.sData = sData;                     //初始化sData域
    }
    //重载run()
    public void run(){
        //同步块，并指出同步数据sData
        synchronized (sData){   //指定同步块，给sData加锁
            for (int i =0; i<5; i++){
                if (this.getName().equals("Thread1")){  //  当前线程是Thread1
                    sData.Data = "这是第一个线程";
                    //设置一次睡眠演示产生的问题
                    try {
                        Thread.sleep((int)Math.random()*50);
                    }catch (InterruptedException e){    //捕获异常
                    }
                    System.out.println(this.getName() +":"+ sData.Data);
                }else if(this.getName().equals("Thread2")){
                    sData.Data = "这是第二个线程";
                    //设置一次睡眠演示产生的问题
                    try {
                        Thread.sleep((int)Math.random()*50);
                    }catch (InterruptedException e){    //捕获异常
                    }
                    System.out.println(this.getName() +":"+ sData.Data);
                }
            }
        }
    }
}