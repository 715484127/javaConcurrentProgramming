package com.javacore.demo.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * 虚引用Demo
 * 对象在回收前会放入引用队列中
 */
public class PhantomReferDemo {
    public static void main(String[] args) throws InterruptedException {
        Object o1 = new Object();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        PhantomReference<Object> phantomReference = new PhantomReference<>(o1,referenceQueue);

        System.out.println(o1);
        System.out.println(phantomReference.get());
        o1 = null;
        System.gc();
        Thread.sleep(500);
        System.out.println(referenceQueue.poll());
    }
}
