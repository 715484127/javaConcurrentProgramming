package com.javacore.demo.prodconsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ProdConsumerBlockQueueDemo {
    public static void main(String[] args) throws Exception {
        MyResource myResource = new MyResource(new ArrayBlockingQueue<>(10));
        new Thread(()->{
            myResource.myProd();
        },"myProd").start();

        new Thread(()->{
            myResource.myConsumer();
        },"myConsumer").start();

        TimeUnit.SECONDS.sleep(5);

        System.out.println();
        System.out.println();
        System.out.println("时间到,停止活动");

        myResource.stop();
    }
}

class MyResource{
    private volatile boolean FLAG = true;
    private BlockingQueue<String> blockingQueue = null;
    private AtomicInteger atomicInteger = new AtomicInteger();

    public MyResource(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public void myProd(){
        String data = null;
        while (FLAG){
            data = atomicInteger.getAndIncrement() + "";
            boolean re = true;
            try {
                re = blockingQueue.offer(data,2L, TimeUnit.SECONDS);
                if (re) {
                    System.out.println(Thread.currentThread().getName() + "\t 插入队列数据" + data + "成功");
                } else {
                    System.out.println(Thread.currentThread().getName() + "\t 插入队列数据" + data + "失败");
                }
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "\t 停止 表示 FLAG=" + FLAG);
    }

    public void myConsumer(){
        String data = null;
        while (FLAG){
            try {
                data = blockingQueue.poll(2L,TimeUnit.SECONDS);
                if (data == null || data.equalsIgnoreCase("")) {
                    FLAG = false;
                    System.out.println(Thread.currentThread().getName()+"\t"+"超过2m没有取到 消费退出");
                    System.out.println();
                    System.out.println();
                    return;
                } else {
                    System.out.println(Thread.currentThread().getName() + "消费队列" + data + "成功");
                }
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "\t 停止 表示 FLAG=" + FLAG);
    }

    public void stop() throws Exception{
        FLAG = false;
    }
}
