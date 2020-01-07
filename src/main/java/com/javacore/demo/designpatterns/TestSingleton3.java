package com.javacore.demo.designpatterns;

/**
 * @author wangyuepeng
 */
public class TestSingleton3 {
    public static void main(String[] args) {
        Singleton3 singleton1 = Singleton3.INSTANCE;
        Singleton3 singleton2 = Singleton3.INSTANCE;
        System.out.println(singleton1 + "\n" + singleton2 + "\n" + (singleton1==singleton2));
    }
}
