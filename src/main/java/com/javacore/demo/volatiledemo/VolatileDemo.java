package com.javacore.demo.volatiledemo;

import java.util.concurrent.TimeUnit;

class User{
    volatile int age = 0;
    public void updateAge(){
        this.age = 60;
    }
}

public class VolatileDemo {
    public static void main(String[] args){
        User user = new User();
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
                user.updateAge();
                System.out.println(Thread.currentThread().getName() + ": update age 60");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        while (user.age == 0){
            //System.out.println("User age = " + user.age);
        }

        System.out.println(Thread.currentThread().getName() + ": now user age = " + user.age);
    }
}
