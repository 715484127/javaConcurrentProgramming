package com.javacore.demo.prodconsumer;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 多个线程之间按顺序调用，实现A->B->C三个线程启动，要求如下：
 * A打印5次，B打印10次，C打印15次
 * 紧接着
 * A打印5次，B打印10次，C打印15次
 * 来10轮
 */
public class SyncAndReentrantLoclDemo {
    public static void main(String[] args) {
        ShareResource shareResource = new ShareResource();
        new Thread(()->{
            try {
                for (int i=1;i<=10;i++){
                    shareResource.print5();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"A").start();

        new Thread(()->{
            try {
                for (int i=1;i<=10;i++){
                    shareResource.print10();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"B").start();

        new Thread(()->{
            try {
                for (int i=1;i<=10;i++){
                    shareResource.print15();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"C").start();
    }
}

class ShareResource{
    private int flag = 1; //1:A打印 2:B打印 3:C打印
    ReentrantLock lock = new ReentrantLock();
    Condition conditionA = lock.newCondition();
    Condition conditionB = lock.newCondition();
    Condition conditionC = lock.newCondition();

    public void print5() throws InterruptedException {
        try{
            lock.lock();
            while (flag != 1){
                conditionA.await();
            }
            for(int i=1;i<=5;i++){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
            flag = 2;
            conditionB.signal();
        }finally {
            lock.unlock();
        }
    }

    public void print10() throws InterruptedException {
        try{
            lock.lock();
            while (flag != 2){
                conditionB.await();
            }
            for(int i=1;i<=10;i++){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
            flag = 3;
            conditionC.signal();
        }finally {
            lock.unlock();
        }
    }

    public void print15() throws InterruptedException {
        try{
            lock.lock();
            while (flag != 3){
                conditionC.await();
            }
            for(int i=1;i<=15;i++){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
            flag = 1;
            conditionA.signal();
        }finally {
            lock.unlock();
        }
    }
}
