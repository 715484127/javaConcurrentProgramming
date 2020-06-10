package com.javacore.demo.prodconsumer;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wangyuepeng
 */
public class ProdConsumerWaitNotifyDemo {
    public static volatile Baozi baozi = null;
    public static void main(String[] args) throws InterruptedException {
        ProdThread prodThread = new ProdThread();
        ConsumerThread consumerThread = new ConsumerThread();
        Thread prodT = new Thread(prodThread,"prodThread");
        Thread consumerT = new Thread(consumerThread,"consumerThread");
        consumerT.start();
        Thread.sleep(1000L);
        prodT.start();

    }

}

class Baozi{

}

/**
 * 生产者
 */
class ProdThread implements Runnable{
    @Override
    public void run() {
        synchronized (ProdConsumerWaitNotifyDemo.class){
            try {
                while(ProdConsumerWaitNotifyDemo.baozi == null){
                    ProdConsumerWaitNotifyDemo.baozi = new Baozi();
                    ProdConsumerWaitNotifyDemo.class.notify();
                    System.out.println("通知消费者有包子了");
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }
}

/**
 * 消费者
 */
class ConsumerThread implements Runnable{
    @Override
    public void run() {
        synchronized (ProdConsumerWaitNotifyDemo.class) {
            try {
                while (ProdConsumerWaitNotifyDemo.baozi == null) {
                    System.out.println("没有包子，进入等待");
                    ProdConsumerWaitNotifyDemo.class.wait();
                }
                System.out.println("买到包子回家");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
