package com.test.demo.ThreadTest.demo6;

class Seller{
    public void giveMeMoney(){
        System.out.println("给我钱，我给你货！");
    }
    public void giveUGoods(){
        System.out.println("货拿走~");
    }
}

class Shopper{
    public void giveMeGoods(){
        System.out.println("给我货，我再付钱！");
    }
    public void giveUMoney(){
        System.out.println("钱给你~");
    }
}

class MyThread implements Runnable{

    private final Seller seller = new Seller();
    private final Shopper shopper = new Shopper();

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        if("seller".equalsIgnoreCase(name)){
            synchronized (seller){
                seller.giveMeMoney();
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (shopper){
                    seller.giveUGoods();
                }
            }
        }else{
            synchronized (shopper){
                shopper.giveMeGoods();
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (seller){
                    shopper.giveUMoney();
                }
            }
        }

    }
}



/**
 * 锁住了
 */
public class ThreadTest {
    public static void main(String[] args){
        MyThread myThread = new MyThread();
        Thread seller = new Thread(myThread,"seller") ;
        Thread shopper = new Thread(myThread,"shopper") ;

        seller.start() ;
        shopper.start() ;

    }
}
