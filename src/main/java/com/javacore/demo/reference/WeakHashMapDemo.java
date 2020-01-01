package com.javacore.demo.reference;

import java.util.WeakHashMap;

/**
 * WeakHashMap 当key没有引用时，垃圾回收执行时会将键值对回收
 */
public class WeakHashMapDemo {
    public static void main(String[] args) {
        WeakHashMap<Integer,String> map = new WeakHashMap<>();
        Integer key = new Integer(2);
        String value = "WeakHashMapDemo";

        map.put(key,value);
        System.out.println(map);


        key = null;
        System.out.println(map);
        System.out.println("=============================");
        System.gc();

        System.out.println(map.get(2));
        System.out.println(map + "\t" + map.size());
    }
}
