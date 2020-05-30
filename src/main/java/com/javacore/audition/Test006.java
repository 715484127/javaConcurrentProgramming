package com.javacore.audition;

/**
 * 二分法查找
 * @author wangyuepeng
 */
public class Test006 {
    public static void main(String[] args){
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Test006 test006 = new Test006();
        int key = 2;
        int index = test006.binarySort(array,key);
        System.out.println("查找:" + key + "的索引是:" + index);
        System.out.println(test006.binarySortRecursion(array, 5, 0, array.length - 1));
    }

    /**
     * 循环方式
     * @param source
     * @param key
     * @return
     */
    int binarySort(int[] source, int key){
        int index = -1;
        int low = 0;
        int high = source.length - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if (key < source[mid]) {
                high = mid - 1;
            } else if (key > source[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return index;
    }

    /**
     * 递归方式
     * @param array
     * @param key
     * @param low
     * @param high
     * @return
     */
    int binarySortRecursion(int[] array, int key, int low, int high) {
        if (low <= high) {
            int mid = (low + high) >>> 1;
            if (key < array[mid]) {
                return binarySortRecursion(array, key, low, mid - 1);
            } else if (key > array[mid]) {
                return binarySortRecursion(array, key, mid + 1, high);
            } else {
                return mid;
            }
        }
        return -1;
    }
}
