package com.javacore.audition;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 文件拷贝 TWR
 * @author wangyuepeng
 */
public class Test003 {
    public static void main(String[] args){
        Test003 test003 = new Test003();
        boolean result = test003.copyFileIO("D:\\新建文本文档.txt","D:\\IOcopy.txt");
        boolean result1 = test003.copyFileNIO("D:\\新建文本文档.txt","D:\\NIOcopy.txt");
        System.out.println("IO：" + result);
        System.out.println("NIO：" + result1);
    }

    /**
     * IO方式拷贝文件
     * @param source
     * @param tag
     * @return
     */
    boolean copyFileIO(String source, String tag){
        boolean result = false;
        try (InputStream is = new FileInputStream(source)) {
            try (OutputStream os = new FileOutputStream(tag);) {
                byte[] buffer = new byte[4096];
                int bytesToRead;
                while ((bytesToRead = is.read(buffer))!= -1) {
                    os.write(buffer,0,bytesToRead);
                }
                result = true;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * NIO方式拷贝文件
     * @param source
     * @param tag
     * @return
     */
    boolean copyFileNIO(String source, String tag){
        boolean result = false;
        try(FileInputStream fis = new FileInputStream(source)) {
            try(FileOutputStream fos = new FileOutputStream(tag)){
                FileChannel fisChannel = fis.getChannel();
                FileChannel fosChannel = fos.getChannel();
                ByteBuffer byteBuffer = ByteBuffer.allocate(4096);
                while(fisChannel.read(byteBuffer) != -1){
                    byteBuffer.flip();   //反转此缓冲区，设置当前位置指针为0，read读文件后文件指针在缓冲区末尾，需要使用flip重置
                    fosChannel.write(byteBuffer);
                    byteBuffer.clear();   //清空缓冲区
                }
                result = true;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
