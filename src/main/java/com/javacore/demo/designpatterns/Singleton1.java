package com.javacore.demo.designpatterns;

/**
 * 饿汉式(线程安全):
 *  直接创建实例对象，不管是不是需要这个对象都会创建
 * (1)构造器私有化
 * (2)自行创建并且用静态变量保存
 * (3)向外提供这个实例
 * (4)强调这是一个单例，我们可以用final修饰
 * @author wangyuepeng
 */
public class Singleton1 {
    public static final Singleton1 INSTANCE = new Singleton1();
    private Singleton1(){
    }
}
