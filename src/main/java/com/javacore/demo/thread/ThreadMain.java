package com.javacore.demo.thread;

import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.FutureTask;

public class ThreadMain {
    public static void main(String[] args){
        TestCallable callable = new TestCallable();
        TestObjectLayout testObjectLayout = new TestObjectLayout();
        System.out.println(testObjectLayout.hashCode());
        System.out.println(ClassLayout.parseInstance(testObjectLayout).toPrintable());
//        for (int i = 0; i < 10; i++) {
//            FutureTask task = new FutureTask(callable);
//            new Thread(task,"子线程"+ i).start();
//            try {
//                //获取子线程的返回值
//                System.out.println("子线程返回值："+task.get() + "\n");
//            }  catch (Exception e) {
//                e.printStackTrace();
//            }
//        }

    }
}

