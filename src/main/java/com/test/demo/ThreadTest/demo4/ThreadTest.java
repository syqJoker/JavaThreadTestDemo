package com.test.demo.ThreadTest.demo4;

class ThreadA extends Thread implements Runnable{

    private int count=0;

    public void setCount(int count){
        this.count = count;
    }

    ThreadA(int inputCount){
        this.count = inputCount;
    }
    ThreadA(int inputCount,String name){
        this.count = inputCount;
        this.setName(name);
    }

    @Override
    public void run() {
        if(count%2==0){
            System.out.println("【"+getName()+"】 count="+count);
        }else{
            yield() ;
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
    ThreadB(int inputCount,String name){
        this.count = inputCount;
        this.setName(name);
    }

    @Override
    public void run() {
        if(count%2==0){
            yield() ;
        }else{
            System.out.println("【"+getName()+"】 count="+count);
        }
    }
}

public class ThreadTest {
    public static void main(String[] args){
        for(int i=0;i<20;i++){
            ThreadA ta = new ThreadA(i);
            new ThreadA(i,"偶数线程").start();
            new ThreadB(i,"奇数线程").start();
        }
    }
}
