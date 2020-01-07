package com.javacore.demo.designpatterns;

/**
 * 懒汉式，延迟创建这个实例对象。(线程安全)
 * (1)构造器私有化
 * (2)用一个静态变量保存这个唯一实例
 * (3)提供一个静态方法，获取这个实例对象
 * @author wangyuepeng
 */
public class Singleton5 {
    private static Singleton5 instance;
    private Singleton5(){
    }

    public static Singleton5 getInstance(){
        if(instance == null){
            synchronized (Singleton5.class) {
                if (instance == null) {
                    instance = new Singleton5();
                }
            }
        }
        return instance;
    }
}
