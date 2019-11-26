package com.jiaxiong;

import java.util.Scanner;
/**
 * @Author: jiaxiong
 * @Date: 2019/7/10 14:37
 * @Version 1.8.0_131
 **/
public class Arrays {
    public static void main(String[] args) {
        /*  在同一个类中：
         *  对于静态方法，其他的静态或非静态方法都可以直接调用它。
         *  而对于非静态方法，其他的非静态方法是可以直接调用它的。但是其他静态方法只有通过对象才能调用它。
         *
         *  不同的类之间，无论调用方法是非静态还是静态，如果被调用的方法是：
         *  静态方法，则通过类名与对象都可以调（但通过对象的方式不建议使用，因为它属于非静态调用的方式）
         *  非静态方法，则只能通过对象才可以调用它
         */
        //静态方法只能通过创建对象才可调用该类其它非静态方法
        //创建类对象
        Arrays arr1 = new Arrays();
        //调用非静态方法
        arr1.testArray();

        //获取打印行数
        System.out.print("请输入打印行数：");
        Scanner s = new Scanner(System.in);
        int row = s.nextInt();
        arr1.Triangle(row);

        //调用静态方法
        int[] a = {12,11,45,6,8,43,40,57,3,20};
        selectSort(a);
        bubbleSort(a);
        quickSort(a,0,a.length-1);
        System.out.println("快速排序后数组：");
        for (int i: a ){
            System.out.print(i+"\t");
        }
    }

    //测试数组初始化
    public void testArray(){
        //new初始化数组
        int[] int_array ;
        int int_array1[] ;

        int_array = new int[5];     //创建数组对象
        for(int i=0; i<5; i++){
            int_array[i] = 2*i;
            //int_array1[i] = 2*i;
            System.out.print(int_array[i]+"\t");
        }
        System.out.println();
        //静态初始化数组
        int[] array1 = {0,1,2,3,4};
        for(int i=0; i<5; i++){
            System.out.print(array1[i]+"\t");
        }
        System.out.println();
    }

    //打印杨辉三角形方法
    public void Triangle(int row){
        //定义二维数组
        int[][] arr = new int[row][];
        //遍历二维数组
        for(int i = 0; i<row; i++){
            //初始化每一行的一维数组
            arr[i] = new int[i+1];
            //遍历这个一维数组
            for(int j=0; j<=i; j++){
                if (j==0 || j==i){  //每行开头结尾都是1
                    arr[i][j] = 1;
                }else {
                    arr[i][j] = arr[i-1][j] + arr[i-1][j-1];
                }
                System.out.print(arr[i][j]+"\t");
            }
            System.out.println();
        }
    }

    //选择排序
    public static void selectSort(int[] a){
        //判断数组非空
        if((a==null) || (a.length==0)){
            System.out.println("数组为空！");
            return;
        }
        //循环遍历
        for(int i=0; i<a.length; i++){
            int minIndex = i;           //最小元素下标
            int minValue = a[minIndex]; //最小元素值
            for (int j=i; j<a.length; j++){
                //用最小值与无序区值作比较
                if (a[j]<minValue){     //重新赋值最小下标
                    minIndex = j;
                    minValue = a[minIndex];
                }
            }
            int temp = a[i];
            a[i] = minValue;//a[i] = a[minIndex]
            a[minIndex] = temp;
        }
        System.out.println("选择排序后数组：");
        for (int i=0; i<a.length; i++){
            System.out.print(a[i] + "\t");
        }
        System.out.println();
    }

    //冒泡排序
    public static void bubbleSort(int[] a){
        //判断数组非空
        if((a==null) || (a.length==0)){
            System.out.println("数组为空！");
            return;
        }
        //循环遍历
        for (int i=0; i<a.length; i++){
            for (int j=i; j<a.length; j++){
                if (a[j]<a[i]){
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        System.out.println("冒泡排序后数组：");
        for (int i=0; i<a.length; i++){
            System.out.print(a[i] + "\t");
        }
        System.out.println();
    }

    //快速排序
    public static int[] quickSort(int[] arr, int low, int high){
        int i,j,temp,t;
//        if (low>high){
//            System.out.println("输入有误！");
//        }
        i = low;
        j = high;
        //temp就是基准位
        temp = arr[low];
        while (i<j){
            //先从右边依次向左遍历j--
            while (temp<arr[j]&&i<j){
                j--;
            }
            //再从左边依次向右遍历i++
            while (temp>arr[j]&&i<j){
                i++;
            }
            //判断两边暂停处的大小
            if ((arr[i]==arr[j])&&(i<j)){
                i++;            //前后相等不需要换位置
            }else {             //否则换位置
                t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }
        //最后将基准位与i,j相等处的值交换
        arr[low] = arr[i];
        arr[i] = temp;
        //分别对左右两边序列递归调用该函数
        if (i-1>low){           //需要判断上下界，否则会溢出出错
            quickSort(arr,low,i-1);
        }
        if (j+1<high){
            quickSort(arr,j+1,high);
        }
        return arr;
    }
}

