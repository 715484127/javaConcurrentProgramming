package com.javacore.demo.designpatterns;

/**
 * @author wangyuepeng
 */
public class TestSingleton6 {
    public static void main(String[] args) {
        Singleton6 singleton1 = Singleton6.getInstance();
        Singleton6 singleton2 = Singleton6.getInstance();
        System.out.println(singleton1 + "\n" + singleton2 + "\n" + (singleton1==singleton2));
    }
}
