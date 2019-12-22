package com.javacore.demo.thread;

import java.util.concurrent.Callable;

public class TestCallable implements Callable {
    private int i = 0;
    @Override
    public Object call() throws Exception {
        boolean exit = false;
        while(!exit){
            i++;
            System.out.println(Thread.currentThread().getName() + "Test Thread for Runnable " + i);
            if(i >= 100){
                exit = true;
            }
        }
        return i;
    }
}
