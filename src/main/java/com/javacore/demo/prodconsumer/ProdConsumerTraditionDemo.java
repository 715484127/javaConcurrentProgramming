package com.javacore.demo.prodconsumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 题目：一个初始值为0的变量，两个线程对其交替操作，一个加1一个减1，交替5轮
 *
 * 多线程编程总结：
 * 1、线程     操作（方法）    资源类
 * 2、判断（要用while判断）     干活           通知
 * 3、防止虚假唤醒机制
 */
public class ProdConsumerTraditionDemo {
    public static void main(String[] args) {
        ShardData shardData = new ShardData();
        new Thread(()->{
            for(int i=0;i<5;i++){
                try {
                    shardData.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"AA").start();

        new Thread(()->{
            for(int i=0;i<5;i++){
                try {
                    shardData.deIncrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"BB").start();

        new Thread(()->{
            for(int i=0;i<5;i++){
                try {
                    shardData.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"CC").start();

        new Thread(()->{
            for(int i=0;i<5;i++){
                try {
                    shardData.deIncrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"DD").start();
    }
}

class ShardData{
    private int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increment() throws InterruptedException { //加1操作
        lock.lock();
        try{
            while (number != 0){
                //等待 不能加1
                condition.await();
            }

            number++;
            System.out.println(Thread.currentThread().getName() + ":\t 加1操作 number=" + number);
            condition.signal();
        }finally {
            lock.unlock();
        }
    }

    public void deIncrement() throws InterruptedException { //减1操作
        lock.lock();
        try{
            while (number == 0){
                //等待 不能减1
                condition.await();
            }

            number--;
            System.out.println(Thread.currentThread().getName() + ":\t 减1操作 number=" + number);
            condition.signal();
        }finally {
            lock.unlock();
        }

    }
}
