package com.cm.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author cm
 * @create 2021/10/30-4:06 下午
 * 直接在堆外内存修改
 */
public class MappedByteBufferTest {
    public static void main(String[] args) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("/Users/wxr/Downloads/DataStructure/nettylearn/2.txt","rw");
        FileChannel channel = randomAccessFile.getChannel();
        MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_WRITE, 0, 5);
        map.put(0,(byte) 'H');
        randomAccessFile.close();
        System.out.println("修改完成");
    }
}
