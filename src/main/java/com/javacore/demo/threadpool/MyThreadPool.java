package com.javacore.demo.threadpool;

import java.util.concurrent.*;

/**
 * 自己写线程池
 */
public class MyThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(2,
                5,
                60L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy());

        System.out.println(Runtime.getRuntime().availableProcessors());//查看CPU核数

        try {
            for (int i = 1; i <= 11; i++) {
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