package com.javacore.demo.designpatterns;

/**
 * @author wangyuepeng
 */
public class TestSingleton5 {
    public static void main(String[] args) {
        Singleton5 singleton1 = Singleton5.getInstance();
        Singleton5 singleton2 = Singleton5.getInstance();
        System.out.println(singleton1 + "\n" + singleton2 + "\n" + (singleton1==singleton2));
    }
}
