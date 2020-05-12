package com.test.demo.ThreadTest.demo3;

class ThreadA extends Thread implements Runnable{

    private int count=0;

    public void setCount(int count){
        this.count = count;
    }

    ThreadA(int inputCount){
        this.count = inputCount;
    }

    @Override
    public void run() {
        if(count%2==0){
            System.out.println("偶数"+count);
        }
    }
}

class ThreadB extends Thread implements Runnable{
    private int count=0;

    public void setCount(int count){
        this.count = count;
    }

    ThreadB(int inputCount){
        this.count = inputCount;
    }

    @Override
    public void run() {
        if(count%2!=0){
            System.out.println("基数"+count);
        }
    }
}

public class ThreadTest {
    public static void main(String[] args){
        for(int i=0;i<20;i++){
            ThreadA ta = new ThreadA(i);
            ThreadB tb = new ThreadB(i);
            new Thread(ta).start();
            new Thread(tb).start();
        }
    }
}
