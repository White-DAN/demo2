package pers.exercise;

/**
 * @Author: jiaxiong
 * @Date: 2019/7/19 15:54
 * @Version 1.8.0_131
 **/
/*
 * 练习：写两个线程，一个线程打印1~52，另一个线程打印A~Z,打印顺序应该是12A34B56C....5152Z
 */

//打印类
class Printer{
    private int index = 1;  //计算输出序列索引
    //打印数字方法
    public synchronized void printNumber(int i){
        if (index%3==0){        //索引为3的整数则数字打印线程等待
            try {
                wait();
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }
        }
        System.out.print(i);
        index++;
        notifyAll();
    }
    //打印字母方法
    public synchronized void printLetter(char c){
        if (index%3 != 0){
            try {
                wait();
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }
        }
        System.out.print(c);
        index++;
        notifyAll();
    }
}

//打印数字线程
class NumberPrint extends Thread{
    //创建打印变量
    Printer pr;
    //构造方法
    public NumberPrint(Printer pr){
        this.pr = pr;
    }
    //实现run方法
    public void run(){
        for (int i=1; i<=52; i++){
            pr.printNumber(i);
        }
    }
}

//打印字母线程
class LetterPrint extends Thread{
    //创建打印变量
    Printer pr;
    //构造方法
    public LetterPrint(Printer pr){
        this.pr = pr;
    }
    //实现run方法
    public void run(){
        for (char c='A'; c<='Z'; c++){
            pr.printLetter(c);
        }
    }
}


public class PrintThread {
    public static void main(String[] args) {
        Printer pr = new Printer();

        NumberPrint np = new NumberPrint(pr);
        LetterPrint lp = new LetterPrint(pr);

        np.start();
        lp.start();
    }
}
