package com.javacore.demo.thread;

public class TestRunnable implements Runnable {
    private boolean exit = false;
    @Override
    public void run() {
        int i = 0;
        while(!exit){
            i++;
            System.out.println("Test Thread for Runnable");
            if(i == 100){
                exit = true;
            }
        }
    }
}
