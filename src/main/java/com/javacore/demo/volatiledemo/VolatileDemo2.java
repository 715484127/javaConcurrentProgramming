package com.javacore.demo.volatiledemo;

import java.util.concurrent.atomic.AtomicInteger;

class User2 {
    volatile int age = 0;
    AtomicInteger atomicInteger = new AtomicInteger();

    public void agePlusPlus(){
        age++;
    }

    public void agePlusPlusAtomic(){
        atomicInteger.getAndIncrement(); //等价于++操作
    }
}

public class VolatileDemo2 {
    public static void main(String[] agrs){
        User2 user2 = new User2();
        for(int i=0;i<20;i++){
            new Thread(() -> {
                for (int j = 0; j < 1000 ; j++) {
                    user2.agePlusPlus();
                    user2.agePlusPlusAtomic();
                }
            },String.valueOf(i)).start();
        }

        //等待20个线程都执行完再执行主线程
        while(Thread.activeCount() > 2){ //当现场数大于2（主线程和gc线程）时，主线程暂停让其它现场继续执行
            Thread.yield();
        }

        System.out.println(Thread.currentThread().getName() + "不保证原子性:" + user2.age);
        System.out.println(Thread.currentThread().getName() + "使用AtomicInteger保证原子性:" + user2.atomicInteger);
    }
}