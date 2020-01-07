package com.javacore.demo.designpatterns;

/**
 * 懒汉式，延迟创建这个实例对象。(线程不安全)
 * (1)构造器私有化
 * (2)用一个静态变量保存这个唯一实例
 * (3)提供一个静态方法，获取这个实例对象
 * @author wangyuepeng
 */
public class Singleton4 {
    private static Singleton4 instance;
    private Singleton4(){
    }

    public static Singleton4 getInstance(){
        if(instance == null){
            instance = new Singleton4();
        }
        return instance;
    }
}
