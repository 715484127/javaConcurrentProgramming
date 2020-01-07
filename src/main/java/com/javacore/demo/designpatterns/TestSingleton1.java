package com.javacore.demo.designpatterns;

/**
 * @author wangyuepeng
 */
public class TestSingleton1 {
    public static void main(String[] args) {
        Singleton1 singleton1 = Singleton1.INSTANCE;
        Singleton1 singleton2 = Singleton1.INSTANCE;
        System.out.println(singleton1 + "\n" + singleton2 + "\n" + (singleton1==singleton2));
    }
}
