package pers.exercise;

/**
 * @Author: jiaxiong
 * @Date: 2019/7/19 16:50
 * @Version 1.8.0_131
 **/
//假设车库有三个车位（可以用boolean[]数组来表示车库）可以停车，写一个程序模拟多个用户开车离开,停车入库的效果。注意：车位有车时不能停车
//一个开车离开线程，一个停车入库线程，一个表示停车场的类
//当停车场满时停车入库线程wait(),
//当停车场空时开车离开线程wait(),

public class ParkTest {
    public static void main(String[] args) {

    }
}

//开车离开线程
class CarOutThread extends Thread{

}

//停车入库线程
class CarInThread extends Thread{

}

//停车场类
class Park{
    private boolean[] arr = new boolean[3];
    private int state = 3;   //表示停车场剩余车位数量

    //开车离开方法
    public synchronized void carOut(){
        if (state==3){      //停车场没有车，离开线程wait()
            System.out.println("空余车位为"+state+ " 请等待！");
            try {
                wait();
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }
        }
        System.out.println("停车成功");
        state -= 1;
        notifyAll();
    }
    //停车方法
    public synchronized void carIn(){
        if (state==0){      //停车场没有空余车位，停车线程wait()
            System.out.println("空余车位为"+state+ " 请等待！");
            try {
                wait();
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }
        }
        System.out.println("离开成功");
        state -= 1;
        notifyAll();
    }
}