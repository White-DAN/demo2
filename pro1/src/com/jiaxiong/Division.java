package com.jiaxiong;
/**
 * @Author: jiaxiong
 * @Date: 2019/7/9 11:24
 * @Version 1.8.0_131
 **/
public class Division {
    public static void main(String[] args) {
        int i= 1;
        int total = 0;      //统计有多少符合的数
        int count = 0;
        while (i<=1000){
            if (i%5 == 0){      //可以被5整除
                total++;
                System.out.print(i + "\t");
                if (total%3 ==0){           //每三个输出换行
                    System.out.print('\n');
                }
            }
            i++;
        }
        System.out.print("\n" );
        System.out.println("符合要求的总个数："+ total);
        for (int t=1;t<=1000;t++){
            if (t%5 == 0){
                System.out.print(t + "\t");

                count++;
            }
            if (t%15 == 0){   //没三个数既是15的整数
                System.out.println();
            }
        }
        System.out.print("\n" );
        System.out.println("符合要求的总个数："+ count);
    }
    int[] int_array = null;
    int int_array1[] = null;
}

