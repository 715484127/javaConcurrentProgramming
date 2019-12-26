package com.javacore.demo.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class CallableDemo {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        FutureTask<Integer> futureTask = new FutureTask<>(myThread);
        Thread thread = new Thread(futureTask);
        thread.start();
        int callable = 0;


        System.out.println(Thread.currentThread().getName() + "==========");

        try {
            /*
            要获得Callable线程计算结果，如果没有计算完成就去强求会导致阻塞，直到线程计算完成。
            一般建议在最后调用FutureTask的get()方法
             */
            callable = futureTask.get();
            System.out.println("===============callable=" + callable);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("==========" + (1 + callable));
    }
}

class MyThread implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName() + ": come in");
        TimeUnit.SECONDS.sleep(2L);
        return 1024;
    }
}