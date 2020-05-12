package com.test.demo.ThreadTest.demo2;

public class ThreadTest{
    public static void main(String[] args){
        MyThread t1 = new MyThread("线程1");
        MyThread t2 = new MyThread("线程2");
        MyRunnable mr = new MyRunnable();
        Thread t3 = new Thread(mr,"线程3");
        Thread t4 = new Thread(mr,"线程4");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
class MyThread extends Thread{
    private int count = 20 ;
    public void run(){
        if(count>0){
            System.out.println(getName() + "运行，i = " + count--) ;
        }
    }
    MyThread(String paramName){
        setName(paramName);
    }
}
class MyRunnable implements Runnable {
    private int count = 20 ;
    public void run(){
        if(count>0){
            System.out.println(Thread.currentThread().getName() + "运行，i = " + count--) ;
        }
    }
}
