package com.javacore.demo.oomdemo;

import java.util.ArrayList;
import java.util.List;

public class GcOverheadDemo {
    public static void main(String[] args) {
        int i = 0;
        List<String> list = new ArrayList<>();

        while(true){
            list.add(String.valueOf(++i).intern());
        }
    }
}
