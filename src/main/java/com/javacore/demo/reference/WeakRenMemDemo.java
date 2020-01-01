package com.javacore.demo.reference;

import java.lang.ref.WeakReference;

/**
 * 弱引用，只要垃圾回收机制一运行对象就会被回收
 */
public class WeakRenMemDemo {
    public static void main(String[] args) {
        Object o1 = new Object();
        WeakReference<Object> weakReference = new WeakReference<>(o1);
        System.out.println(o1);
        System.out.println(weakReference.get());

        o1 = null;
        System.gc();
        System.out.println("============================");

        System.out.println(o1);
        System.out.println(weakReference.get());
    }
}
