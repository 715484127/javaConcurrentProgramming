package com.javacore.demo.blockingqueuedemo;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class SynchronousQueueDemo {
    public static void main(String[] args) {
        BlockingQueue<String> syncblockingQueue = new SynchronousQueue<>();

        new Thread(()->{
            try {
                System.out.println(Thread.currentThread().getName() + ":\t put a");
                syncblockingQueue.put("a");
                System.out.println(Thread.currentThread().getName() + ":\t put b");
                syncblockingQueue.put("b");
                System.out.println(Thread.currentThread().getName() + ":\t put c");
                syncblockingQueue.put("c");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        },"AAA").start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(5);
                System.out.println(syncblockingQueue.take());
                TimeUnit.SECONDS.sleep(5);
                System.out.println(syncblockingQueue.take());
                TimeUnit.SECONDS.sleep(5);
                System.out.println(syncblockingQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"BBB").start();
    }
}
