package com.javacore.demo.deadlocl;

import java.util.concurrent.TimeUnit;

public class DeadLockDemo {
    public static void main(String[] args) {
        HoldLock holdLockA = new HoldLock("lockA","lockB");
        HoldLock holdLockB = new HoldLock("lockB","lockA");
        new Thread(()->{
            try {
                holdLockA.deadLock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"AA").start();

        new Thread(()->{
            try {
                holdLockB.deadLock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"BB").start();
    }
}

class HoldLock{
    private String lockA;
    private String lockB;

    public HoldLock(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    public void deadLock() throws InterruptedException {
        synchronized (lockA){
            System.out.println(Thread.currentThread().getName() + ":自己持有" + lockA + "尝试获取" + lockB);
            TimeUnit.SECONDS.sleep(1L);
            synchronized (lockB){
                System.out.println(Thread.currentThread().getName() + ":自己持有" + lockB + "尝试获取" + lockA);
            }
        }
    }
}
