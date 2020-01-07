package com.javacore.demo.designpatterns;

/**
 * 饿汉式，静态方法块实现(线程安全)
 * @author wangyuepeng
 */
public class Singleton3 {
    public static final Singleton3 INSTANCE;

    static {
        INSTANCE = new Singleton3();
    }
}
