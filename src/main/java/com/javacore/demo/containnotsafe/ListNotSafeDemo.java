package com.javacore.demo.containnotsafe;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class ListNotSafeDemo {
    public static void main(String[] args) {
        List<String> list = new CopyOnWriteArrayList<>();

        for(int i=0;i<30;i++){
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            }).start();
        }
    }
}
