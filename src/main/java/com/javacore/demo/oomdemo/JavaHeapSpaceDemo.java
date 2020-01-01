package com.javacore.demo.oomdemo;

import java.util.Random;

public class JavaHeapSpaceDemo {
    public static void main(String[] args) {
        String str = "wangyuepeng";
        while(true){
            str += str + new Random().nextInt(111111) + new Random().nextInt(22222);
            str.intern();
        }

    }
}
