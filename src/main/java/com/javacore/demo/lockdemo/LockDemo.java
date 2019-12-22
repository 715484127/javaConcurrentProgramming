package com.javacore.demo.lockdemo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

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
