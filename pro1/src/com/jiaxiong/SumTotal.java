package com.jiaxiong;

/**
 * @Author: jiaxiong
 * @Date: 2019/7/9 11:01
 * @Version 1.8.0_131
 **/
public class SumTotal {
    public static void main(String[] args) {
        int i = 0;
        int sum_total = 0;      //保存总和
        int sum_odd = 0;        //保存奇数和
        int sum_even = 0;

         while(i<= 100) {
             sum_total += i;//总和
             if(i%2==0){        //如果是偶数
                 sum_even += i;
             }else {            //否则是奇数
                 sum_odd += i;
             }
            i++;
         }
        System.out.println("奇数和为：" + sum_odd);
        System.out.println("偶数和为：" + sum_even);
        System.out.println("总数和为：" + sum_total);

        for(i=0; i<=100; i++){
            if(i%2==0){        //如果是偶数
                sum_even += i;
            }else {            //否则是奇数
                sum_odd += i;
            }
        }
        System.out.println("奇数和为：" + sum_odd);
        System.out.println("偶数和为：" + sum_even);
        System.out.println("总数和为：" + sum_total);
    }
}
