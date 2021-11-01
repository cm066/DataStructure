package com.cm.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author cm
 * @create 2021/10/30-11:05 上午
 */
public class NIOChannaelFile2 {
    public static void main(String[] args) throws IOException {
        File file = new File("/Users/wxr/Downloads/DataStructure/nettylearn/file.txt");
        FileInputStream inputStream = new FileInputStream(file);
        FileChannel channel = inputStream.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate((int) file.length());
        channel.read(buffer);
        System.out.println(new String(buffer.array()));
        inputStream.close();
    }
}
