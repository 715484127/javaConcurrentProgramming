package com.javacore.demo.serializable;

import java.io.Serializable;

/**
 * 需要满足以下要求才能序列化：
 * 1、实现接口：Serializable
 * 2、提供一个全局变量serialVersionUID
 * @author wangyuepeng
 */
public class Person implements Serializable {
    private static final long serialVersionUID = -3103119003340392755L;
    public String name;
    public int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
