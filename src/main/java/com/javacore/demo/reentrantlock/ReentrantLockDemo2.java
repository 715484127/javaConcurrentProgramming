package com.javacore.demo.reentrantlock;

/**
 * 子类重写父类的synchronized方法,如果没有可重入锁机制将会导致死锁
 * 《Java 并发编程实战》 -- page21 重入
 * @author wyp
 */
public class ReentrantLockDemo2 {
    public static void main(String[] args){
        LoggingWidget loggingWidget = new LoggingWidget();
        loggingWidget.doSomething();
    }
}

class Widget{
    public synchronized void doSomething(){
        System.out.println("Widget中的this: " + this);
    }
}

class LoggingWidget extends Widget{
    @Override
    public synchronized void doSomething() {
        super.doSomething();
        System.out.println("LoggingWidget中的super: " + super.toString());
        System.out.println("LoggingWidget中的this: " + this);
    }
}
