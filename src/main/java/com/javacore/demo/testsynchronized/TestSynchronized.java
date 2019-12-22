package com.javacore.demo.testsynchronized;

public class TestSynchronized {
    public static void main(String[] args){
        BookTicket bookTicket = new BookTicket();
        for(int i=0;i<5;i++){
            Thread thread = new Thread(bookTicket,"线程:" + i);
            thread.start();
        }
    }
}

class BookTicket implements Runnable{
    private static int ticket = 0;
    @Override
    public void run() {
        synchronized (this){
            ticket++;
            System.out.println(Thread.currentThread().getName() + "====" + ticket);
        }
    }
}
