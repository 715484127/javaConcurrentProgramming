package com.javacore.demo.thread;

public class TestThread extends Thread{
    @Override
    public void run() {
        int i = 0;
        for(int j=0;j<100000;j++){
            System.out.println(i++);
        }

    }
}
