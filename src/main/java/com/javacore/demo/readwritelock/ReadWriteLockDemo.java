package com.javacore.demo.readwritelock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class MyCaChe{
    //保证可见性
    private volatile Map<String,Object> myMap = new HashMap<>();
    ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

    public void put(String key, Object value){
        reentrantReadWriteLock.writeLock().lock(); //写锁
        try{
            System.out.println(Thread.currentThread().getName() + ":正在写入key=" + key);
            myMap.put(key,value);
            System.out.println(Thread.currentThread().getName() + ":写入完成key=" + key);
        }finally {
            reentrantReadWriteLock.writeLock().unlock();
        }

    }

    public void get(String key){
        reentrantReadWriteLock.readLock().lock(); //读锁
        try {
            System.out.println(Thread.currentThread().getName() + ":正在读取key=" + key);
            myMap.get(key);
            System.out.println(Thread.currentThread().getName() + ":读取完成key=" + key);
        }finally {
            reentrantReadWriteLock.readLock().unlock();
        }

    }
}

/**
 * Description:
 * 多个线程同时操作 一个资源类没有任何问题 所以为了满足并发量
 * 读取共享资源应该可以同时进行
 * 但是
 * 如果有一个线程想去写共享资源来  就不应该有其他线程可以对资源进行读或写
 * <p>
 * 小总结:
 * 读 读能共存
 * 读 写不能共存
 * 写 写不能共存
 * 写操作 原子+独占 整个过程必须是一个完成的统一整体 中间不允许被分割 被打断
 *
 **/

public class ReadWriteLockDemo {
    public static void main(String[] args) {
        MyCaChe myCaChe = new MyCaChe();
        for(int i = 0; i<5; i++){
            final int temp = i;
            new Thread(()->{
                myCaChe.put(String.valueOf(temp),temp);
                try {
                    TimeUnit.MILLISECONDS.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }

        for(int i = 0; i<5; i++){
            final int temp = i;
            new Thread(()->{
                myCaChe.get(String.valueOf(temp));
            },String.valueOf(i)).start();
        }

    }
}
