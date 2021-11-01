package com.cm.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * @author cm
 * @create 2021/10/30-3:37 下午
 */
public class NIOChannaelFile4 {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream("/Users/wxr/Downloads/DataStructure/nettylearn/1.png");
        FileOutputStream outputStream = new FileOutputStream("/Users/wxr/Downloads/DataStructure/nettylearn/2.png");
        FileChannel inputStreamChannel = inputStream.getChannel();
        FileChannel channel = outputStream.getChannel();
        channel.transferFrom(inputStreamChannel,0,inputStreamChannel.size());
        inputStream.close();
        outputStream.close();


    }
}
