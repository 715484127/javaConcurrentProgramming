package com.javacore.demo.reentrantlock;

class User{
    public synchronized void sendSMS(){
        System.out.println(Thread.currentThread().getName() + ":sendSMS");
        sendEmail();
    }
    public synchronized void sendEmail(){
        System.out.println(Thread.currentThread().getName() + ":sendEmail");
    }
}

public class ReentrantLockDemo {
    public static void main(String[] args) {
        User user = new User();
        for(int i=0;i<3;i++){
            new Thread(() -> {
                user.sendSMS();
            }).start();
        }
    }
}
