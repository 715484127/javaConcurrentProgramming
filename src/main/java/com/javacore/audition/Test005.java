package com.javacore.audition;

import java.util.Arrays;

/**
 * 冒泡排序
 * @author wangyuepeng
 */
public class Test005 {
    public static void main(String[] args){
        Test005 test005 = new Test005();
        int[] source = {100,10,3,11,44,22,90,101,400,450,33,11,3,22};
        source = test005.bubbleSort(source);
        System.out.println(Arrays.toString(source));
    }

    int[] bubbleSort(int[] source){
        int len = source.length;
        for(int i = 0; i < len; i++) {
            for(int j = 0, subLen = len - 1 - i; j < subLen; j++) {
                if(source[j + 1] < source[j]) {
                    int tmp = source[j + 1];
                    source[j + 1] = source[j];
                    source[j] = tmp;
                }
            }
        }
        return source;
    }
}
