package com.javacore.demo.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for(int i=1;i<=6;i++){
            final int temp = i;
            new Thread(()->{
                System.out.println("人" + temp + "离开房间");
                countDownLatch.countDown();
            }).start();
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("管理员锁门！！！");
    }
}
