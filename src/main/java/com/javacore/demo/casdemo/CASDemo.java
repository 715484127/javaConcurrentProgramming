package com.javacore.demo.casdemo;

import java.util.concurrent.atomic.AtomicInteger;

public class CASDemo {
    public static void main(String[] args){
        AtomicInteger atomicInteger = new AtomicInteger(5);
        System.out.println(atomicInteger.compareAndSet(5, 2019) + ":now atomicInteger = " + atomicInteger);
        System.out.println(atomicInteger.compareAndSet(5, 1024) + ":now atomicInteger = " + atomicInteger);
    }
}
