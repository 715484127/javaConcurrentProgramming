package com.javacore.demo.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wangyuepeng
 */
public class TestStopThread {
    public static void main(String[] args) throws InterruptedException {
        MyBean myBean = new MyBean();
        MyThread1 myThread1 = new MyThread1(myBean);
        Thread thread = new Thread(myThread1);
        thread.start();
        Thread.sleep(100L);
        //thread.stop();
        thread.interrupt();
        System.out.println(thread.getName() + ":i=" + myBean.getI() + ",j=" + myBean.getJ());
    }
}

class MyThread1 implements Runnable{
    MyBean myBean;
    public MyThread1(MyBean myBean) {
        this.myBean = myBean;
    }

    @Override
    public void run() {
        Lock lock = new ReentrantLock();
        lock.lock();
        try{
            this.myBean.setI(this.myBean.getI() + 1);
            System.out.println("i=" + this.myBean.getI());
            Thread.sleep(1000L);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        this.myBean.setJ(this.myBean.getJ() + 1);
        System.out.println("j=" + this.myBean.getJ());

    }
}

class MyBean{
    int i = 0;
    int j = 0;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }
}
