package com.cm.nio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author cm
 * @create 2021/10/30-10:47 上午
 */
public class NIOChannaelFile {
    public static void main(String[] args) throws IOException {
        String s = "hello 陈明";
        FileOutputStream outputStream = new FileOutputStream("/Users/wxr/Downloads/DataStructure/nettylearn/file.txt");
        FileChannel channel = outputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byteBuffer.put(s.getBytes());
        byteBuffer.flip();
        channel.write(byteBuffer);
        outputStream.close();
    }
}
