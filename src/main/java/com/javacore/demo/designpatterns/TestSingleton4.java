package com.javacore.demo.designpatterns;

/**
 * @author wangyuepeng
 */
public class TestSingleton4 {
    public static void main(String[] args) {
        Singleton4 singleton1 = Singleton4.getInstance();
        Singleton4 singleton2 = Singleton4.getInstance();
        System.out.println(singleton1 + "\n" + singleton2 + "\n" + (singleton1==singleton2));
    }
}
