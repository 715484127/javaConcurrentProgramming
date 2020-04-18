package com.javacore.demo.serializable;

import java.io.*;

/**
 * 序列化过程:将java对象保存到磁盘中
 * 反序列化过程:将磁盘中的对象还原成内存中的对象
 * @author wangyuepeng
 */
public class SerializableDemo {
    public static void main(String[] args) {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("object.dat"));
            //oos.writeObject(new String("java序列化测试"));
            oos.writeObject(new Person("张三",43));
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(oos != null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("object.dat"));
            Object o = ois.readObject();
            Person s = (Person) o;
            System.out.println(s.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(ois != null){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
