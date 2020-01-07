package com.javacore.demo.designpatterns;

/**
 * @author wangyuepeng
 */
public class TestSingleton2 {
    public static void main(String[] args) {
        Singleton2 singleton1 = Singleton2.INSTANCE;
        Singleton2 singleton2 = Singleton2.INSTANCE;
        System.out.println(singleton1 + "\n" + singleton2 + "\n" + (singleton1==singleton2));
    }
}
