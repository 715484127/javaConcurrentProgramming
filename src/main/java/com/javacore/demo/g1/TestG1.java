package com.javacore.demo.g1;

import java.util.Random;

/**
 * 启动参数 -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+UseG1GC
 * @author wangyuepeng
 */
public class TestG1 {
    public static void main(String[] args){
        String str = "测试G1垃圾收集器";
        while (true){
            str += str + new Random().nextInt(777777) + new Random().nextInt(222222);
            str.intern();
        }
    }
}
