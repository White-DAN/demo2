package com.jiaxiong;

/**
 * @Author: jiaxiong
 * @Date: 2019/7/19 14:39
 * @Version 1.8.0_131
 **/
//线程通信

//账户类
class Account{
    //账户编号，账户余额两个成员变量
    private String accountNum;
    private double balance;
    //标记账户中是否已有存款
    private boolean flag = false;

    public Account(){}
    //构造函数
    public Account(String accountNum, double balance){
        this.accountNum = accountNum;
        this.balance = balance;
    }
    //accountNum的setter和getter方法
    public void setAccountNum(String accountNum){
        this.accountNum = accountNum;
    }
    public String getAccountNum(){
        return accountNum;
    }
    //账户余额不允许随便更改，只提供balance的getter方法
    public double getBalance(){
        return balance;
    }
    //取钱方法
    public synchronized void draw(double drawMoney){
        if (flag){  //如果flag为真表明账户中有人存钱进去，可执行取钱方法
            //执行取钱操作
            System.out.println(Thread.currentThread().getName() + "取钱" + drawMoney);
            balance -= drawMoney;
            flag = false;
            notifyAll();
        }else {
            try{
                wait();     //取钱线程阻塞（等待）
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }
        }
    }
    //存钱方法
    public synchronized void  deposit(double depositMoney){
        if (flag){
            try{
                wait();
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }
        }else {
            //执行存钱操作
            System.out.println(Thread.currentThread().getName()+ "存款"+ depositMoney);
            balance += depositMoney;
            flag = true;
            notifyAll();
        }
    }

}

//存钱者线程
class DepositThread extends Thread{
    //用户账户
    private Account acc;
    //当前存钱线程希望存的钱数
    private double depositMoney;
    //构造函数
    public DepositThread(String name, Account acc, double depositMoney){
        super(name);
        this.acc = acc;
        this.depositMoney = depositMoney;
    }
    //重复10次执行存款操作
    public void run(){
        for (int i=0; i<50; i++){
            acc.deposit(depositMoney);
        }
    }
}

//取钱者线程
class DrawThread extends Thread{
    //用户账户
    private Account acc;
    //当前存钱线程希望取的钱数
    private double drawMoney;
    //构造函数
    public DrawThread(String name, Account acc, double drawMoney){
        super(name);
        this.acc = acc;
        this.drawMoney = drawMoney;
    }
    //重复10次执行取钱操作
    public void run(){
        for (int i=0; i<50; i++){
            acc.draw(drawMoney);
        }
    }
}


public class TestThread {
    public static void main(String[] args) {
        //创建一个账户
        Account acc = new Account("12345", 0);
        DrawThread dr = new DrawThread("取钱者", acc, 800);
        DepositThread de = new DepositThread("存钱者甲", acc, 800);
        DepositThread de1 = new DepositThread("存钱者乙", acc, 800);
        DepositThread de2 = new DepositThread("存钱者丙", acc, 800);

        dr.start();
        de.start();
        de1.start();
        de2.start();

    }
}
