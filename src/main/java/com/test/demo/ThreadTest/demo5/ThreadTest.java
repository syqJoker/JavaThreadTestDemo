package com.test.demo.ThreadTest.demo5;

class MyThread extends Thread implements Runnable{

    private int count=25;

    public void setCount(int count){
        this.count = count;
    }

    MyThread(int inputCount){
        this.count = inputCount;
    }
    MyThread(String name){
        this.setName(name);
    }
    MyThread(int inputCount,String name){
        this.count = inputCount;
        this.setName(name);
    }

    @Override
    public void run() {
        while (count > 0){
            if(2<count && count<12){
                if(count%2==0){
//                    this.funB(i);
                    this.synFunB(count);
                }else{
//                    this.funA(i);
                    this.synFunA(count);
                }
            }
            count--;
        }
    }

    public synchronized void synFunA(int count){
        System.out.println("【"+getName()+"】是奇数 count="+count);
    }
    public synchronized void synFunB(int count){
        System.out.println("【"+getName()+"】是偶数 count="+count);
    }

    public void funA(int count){
        System.out.println("【"+getName()+"】##非同步方法## 是奇数 count="+count);
    }
    public void funB(int count){
        System.out.println("【"+getName()+"】##非同步方法## 是偶数 count="+count);
    }
}
class MyThreadTheed implements Runnable{
    private int ticket = 5 ;    // 假设一共有5张票
    public void run(){
        for(int i=0;i<100;i++){
            this.sale() ;   // 调用同步方法
        }
    }
    public synchronized void sale(){    // 声明同步方法
        if(ticket>0){   // 还有票
            try{
                Thread.sleep(300) ; // 加入延迟
            }catch(InterruptedException e){
                e.printStackTrace() ;
            }
            System.out.println("卖票：ticket = " + ticket-- );
        }

    }
}
class MyThreadOther implements Runnable{

    private int count=25;

    @Override
    public void run() {
        while (count > 0){
//            System.out.println("【"+Thread.currentThread().getName()+"】count="+count);
            synFun();

        }
    }

    public synchronized void synFun(){
        if(2<count && count<12){
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(count%2==0){
                this.funB(count);
            }else{
                this.funA(count);
            }
        }
        count--;
    }

    public void funA(int count){
        System.out.println("【"+Thread.currentThread().getName()+"】##非同步方法## 是奇数 count="+count);
    }
    public void funB(int count){
        System.out.println("【"+Thread.currentThread().getName()+"】##非同步方法## 是偶数 count="+count);
    }

}


class MyThreadForth implements Runnable{
    private int count=25;

    @Override
    public void run() {
        while (count > 0){
            synFun();
        }
    }

    public synchronized void synFun(){
        if(2<count && count<18){
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(count%2==0){
                this.funB(count);
            }else{
                this.funA(count);
            }
        }
        count--;
    }

    public void funA(int count){
        System.out.println("【"+Thread.currentThread().getName()+"】##非同步方法## 是奇数 count="+count);
    }
    public void funB(int count){
        System.out.println("【"+Thread.currentThread().getName()+"】##非同步方法## 是偶数 count="+count);
    }

}



/**
 * 同步
 */
public class ThreadTest {
    public static void main(String[] args){
//        new MyThread("我的线程").start();
//        new MyThread("我的线程2").start();
//        new MyThread("我的线程32").start();

//        MyThreadOther myo = new MyThreadOther();
//        new Thread(myo,"t1").start();
//        new Thread(myo,"t2").start();
//        new Thread(myo,"t3").start();
//
//
//        MyThreadTheed mtt = new MyThreadTheed();
//        new Thread(mtt,"t1").start();
//        new Thread(mtt,"t2").start();
//        new Thread(mtt,"t3").start();

        MyThreadForth mtf = new MyThreadForth();
        new Thread(mtf,"sssssss").start();
        new Thread(mtf,"ddddddd").start();
        new Thread(mtf,"aaaaaaa").start();
    }
}
