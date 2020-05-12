package com.test.demo.ThreadTest.demo6;

public class ThreadTest2 {
    public static void main(String[] args) {
        Person person = new Person();
        Thread thread1 = new Thread(person,"买家");
        Thread thread2 = new Thread(person,"卖家");
        thread1.start();
        thread2.start();
        System.out.println("主线程执行完毕。");
    }
}
class Person implements Runnable {

    private String t1 = "货";
    private String t2 = "钱";

    @Override
    public void run() {
        getChopsticks();
    }
    public void getChopsticks() {
        String name = Thread.currentThread().getName();
        if(name.equals("买家")) {
            synchronized (t1) {
                System.out.println(name + "说：你给我货，我给你钱");
                //两个线程进来时，A在拿到第一根筷子时，第二根筷子可能给B拿了，此时不断的等待B释放第二根筷子的锁
                synchronized(t2) {
                    System.out.println(name + "拿到第二根筷子，开始吃饭。");
                }
            }
        }else {
            synchronized (t2) {
                System.out.println(name + "拿到第二根筷子，B准备拿第一根筷子。");
                //两个线程进来时，B在拿到第二根筷子时，第一根筷子可能给A拿了，此时不断的等待A释放第一根筷子的锁
                synchronized(t1) {
                    System.out.println(name + "拿到第一根筷子，开始吃饭。");
                }
            }
        }
    }
}
