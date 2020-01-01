package com.javacore.demo.reference;

import java.lang.ref.SoftReference;

/**
 * 软引用demo
 * 内存够用时就保留，不够用时就回收
 */
public class SoftRenMemDemo {
    public static void main(String[] args) {
        Object o1 = new Object();
        SoftReference<Object> softReference = new SoftReference<>(o1);
        System.out.println(o1);
        System.out.println(softReference.get());

        o1 = null;
        try{
            byte[] bytes = new byte[30 * 1024 * 1024];
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println(o1);
            System.out.println(softReference.get());
        }
    }
}
