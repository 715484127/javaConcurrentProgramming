package com.javacore.demo.thread;

import java.util.stream.Stream;

public class TestSleepWait {
    private final static Object lock = new Object();
    public static void main(String[] args) {
        Stream.of("线程1","线程2").forEach(n->new Thread(n) {
            public void run(){
                TestSleepWait.testSleep();
            }
        }.start());
    }

    private static void testSleep() {
        synchronized (lock) {
            try {
                System.out.println(Thread.currentThread().getName()
                        +"正在执行");
                //Thread.sleep(10000);
                lock.wait(10000);
                System.out.println(Thread.currentThread().getName()
                        +"休眠结束");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
