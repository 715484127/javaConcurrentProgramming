package com.javacore.demo.designpatterns;

/**
 * 懒汉式，延迟创建这个实例对象。(线程安全)
 * (1)构造器私有化
 * (2)用一个静态变量保存这个唯一实例
 * (3)提供一个静态方法，获取这个实例对象
 *
 * 在内部类被加载和初始化时，才创建INSTANCE实例对象
 * 静态内部类不会自动随着外部类的加载和初始化而初始化，它是要单独去加载和初始化的
 * @author wangyuepeng
 */
public class Singleton6 {
    private Singleton6(){
    }

    private static class Inner{
        private static final Singleton6 INSTANCE = new Singleton6();
    }

    public static Singleton6 getInstance(){
        return Inner.INSTANCE;
    }
}
