package com.javacore.test;

public class Demo1 {
    public static void main(String[] args) {
        int i = 1;
        i = i++;
        System.out.println("=========== i= " + i);
        int j = i++;
        System.out.println("=========== j= " + j);
    }
}
