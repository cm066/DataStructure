package com.cm.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author cm
 * @create 2021/10/30-11:17 上午
 */
public class NIOChannaelFile3 {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream1 = new FileInputStream("/Users/wxr/Downloads/DataStructure/nettylearn/1.txt");
        FileOutputStream outputStream = new FileOutputStream("/Users/wxr/Downloads/DataStructure/nettylearn/2.txt");
        FileChannel inputStream1Channel = inputStream1.getChannel();
        FileChannel outputStreamChannel = outputStream.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(512);
        while (true){
            //清除，不然要重复的读取
            buffer.clear();
            int read = inputStream1Channel.read(buffer);
            if (read == -1){
                break;
            }
            buffer.flip();
            outputStreamChannel.write(buffer);
        }
        inputStream1.close();
        outputStream.close();
    }
}
