package com.jiaxiong;

//import java.util.Queue;

/**
 * @Author: jiaxiong
 * @Date: 2019/7/18 16:50
 * @Version 1.8.0_131
 **/
//线程通信

//共享队列，用于保存生产者生产，消费者消费的共享数据
class Queue{
    int value = 0;              //声明，并初始化，value表示共享队列中元素的数目
    boolean isEmpty = true;     //声明，并初始化布尔类型数据域isEmpty,用于判断队列的状态
    //生产者生产方法
    public synchronized void put(int v){
        //如果队列为空（isEmpty == true）生产者产生数据，否则队列非空(isEmpty == false)即共享数据没有被消费，生产者等待
        System.out.println("生产者第v= " + v +"次进入，此时isEmpty ="+ isEmpty);
        if (!isEmpty){
            try {
                System.out.println("生产者等待");
                wait();         //进入等待状态
            }catch (Exception ex){
                ex.printStackTrace();//异常信息输出
            }
        }
        else {
            value += v;         //队列数据数目
            isEmpty = false;     //队列非空重新赋值
            System.out.println("生产者共生产数量："+ v);
            notifyAll();        //生产之后通知消费者消费
        }

//        if (!isEmpty){
//            try {
//                System.out.println("生产者等待");
//                wait();         //进入等待状态
//            }catch (Exception ex){
//                ex.printStackTrace();//异常信息输出
//            }
//        }
//        value += v;         //队列数据数目
//        isEmpty = false;     //队列非空重新赋值
//        System.out.println("生产者共生产数量："+ v);
//        notifyAll();        //生产之后通知消费者消费

        System.out.println("生产方法结束后v = "+ v);
}
    //消费者消费方法
    public synchronized int get(){
        System.out.println("消费者进入,此时isEmpty ="+ isEmpty);
        //消费者消费前，如果队列为空（isEmpty == true）即共享数据已经被消费完，则消费者等待；否则队列非空(isEmpty == false)即共享数据没有被消费，消费者进行消费
        if (isEmpty){
            try{
                System.out.println("消费者等待");
                wait();
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
//        else {//进行消费
//            value --;
//            if (value<1){
//                isEmpty = true;
//            }
//            System.out.println("消费者消费一个，剩余："+ value);
//            notifyAll();                //消费者消费后，通知生产者生产
//        }
        value --;
        if (value<1){
            isEmpty = true;
        }
        System.out.println("消费者消费一个，剩余："+ value);
        notifyAll();                //消费者消费后，通知生产者生产
        return value;
    }
}

//生产者线程
class Producer extends Thread{
    Queue q;        //声明队列
    Producer(Queue q){     //生产者构造方法
        this.q = q;         //队列初始化
    }
    //重载run
    public void run(){
        for (int i=1; i<5; i++){
            q.put(i);           // 给队列添加新的元素
            //System.out.println("生产者共生产："+ i);
        }
    }
}

//消费者线程
class Consumer extends Thread{
    Queue q;
    Consumer(Queue q){
        this.q = q;
    }
    public void run(){
        while (true){           //循环消费元素
            q.get();            //获取队列中的元素
        }
    }
}

public class ThreadCommunication {
    public static void main(String[] args) {
        Queue q = new Queue();
        Producer p = new Producer(q);
        Consumer c = new Consumer(q);

        c.start();
        p.start();
    }
}