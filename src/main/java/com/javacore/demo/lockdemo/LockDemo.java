package com.javacore.demo.lockdemo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 在使用阻塞等待获取锁的方式中，必须在try代码块之外，并且在加锁方法与try代码块之间没有任何可能抛出异常的方法调用，避免加锁成功后，在finally中无法解锁。
 * 说明一：如果在lock方法与try代码块之间的方法调用抛出异常，那么无法解锁，造成其它线程无法成功获取锁。
 * 说明二：如果lock方法在try代码块之内，可能由于其它方法抛出异常，导致在finally代码块中，unlock对未加锁的对象解锁，它会调用AQS的tryRelease方法（取决于具体实现类），抛出IllegalMonitorStateException异常。
 * 说明三：在Lock对象的lock方法实现中可能抛出unchecked异常，产生的后果与说明二相同。
 */
class Ticket{
    private int number = 30;
    Lock myLock = new ReentrantLock();
    public void sale(){
        myLock.lock();
        try {
            if(number > 0){
                number--;
                System.out.println(Thread.currentThread().getName() + ":卖出1张票剩余:" + number);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            myLock.unlock();
        }

    }
}

public class LockDemo {
    public static void main(String args[]){
        Ticket ticket = new Ticket();
        new Thread(() -> {
            for (int i=0;i<40;i++){
                ticket.sale();
            }
        },"AA").start();

        new Thread(() -> {
            for (int i=0;i<40;i++){
                ticket.sale();
            }
        },"BB").start();

        new Thread(() -> {
            for (int i=0;i<40;i++){
                ticket.sale();
            }
        },"CC").start();
    }
}
