package com.javacore.demo.singletondemo;

public class SingletonDemo {
    public static volatile SingletonDemo singletonDemo = null;
    SingletonDemo(){
        System.out.println(Thread.currentThread().getName() + ":我是构造方法");
    }

    public static SingletonDemo getInstance(){
        if(singletonDemo == null){
            synchronized (SingletonDemo.class){
                if(singletonDemo == null){
                    singletonDemo = new SingletonDemo();
                }
            }
        }
        return singletonDemo;
    }

    public static void main(String[] args){
        for(int i=0;i<10;i++){
            new Thread(() -> {
                SingletonDemo.getInstance();
            }).start();
        }
    }
}