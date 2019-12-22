package com.javacore.demo.reentrantlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Phone{
    Lock lock = new ReentrantLock();
    public void get(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + ":get()");
            set();
        }finally {
            lock.unlock();
        }
    }

    public void set(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + ":set()");
        }finally {
            lock.unlock();
        }
    }
}

public class ReentrantLockDemo1 {
    public static void main(String[] args) {
        Phone phone = new Phone();
        for(int i=0;i<3;i++){
            new Thread(() -> {
                phone.get();
            }).start();
        }
    }
}
