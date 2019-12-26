package com.javacore.demo.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo {
    public static void main(String[] args) {
        //一个线程池5个处理线程
        //ExecutorService executorService = Executors.newFixedThreadPool(5);
        //一个线程池1个处理线程
        //ExecutorService executorService = Executors.newSingleThreadExecutor();
        //一个线程池N个处理线程
        ExecutorService executorService = Executors.newCachedThreadPool();
        try {
            //模拟10个人办业务，但是只有5个窗口
            for (int i = 1; i <= 10; i++) {
                final int people = i;
                executorService.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + ":" + people + "办业务");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }


    }
}
