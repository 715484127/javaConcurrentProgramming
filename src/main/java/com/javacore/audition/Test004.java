package com.javacore.audition;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author wangyuepeng
 */
public class Test004 {
    public static void main(String[] args){
        Test004 test004 = new Test004();
        int count = test004.wordCount("D:\\新建文本文档.txt","hello");
        System.out.println(count);
    }

    int wordCount(String fileName, String word){
        int count = 0;
        try(FileReader fr = new FileReader(fileName)){
            try(BufferedReader br = new BufferedReader(fr)){
                String line;
                while((line = br.readLine()) != null){
                    int index = -1;
                    while(line.length() >= word.length() && (index = line.indexOf(word)) >= 0){
                        count ++;
                        line = line.substring(index + word.length());
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return count;
    }
}
