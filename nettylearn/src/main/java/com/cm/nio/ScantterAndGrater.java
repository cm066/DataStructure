package com.cm.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

/**
 * @author cm
 * @create 2021/10/30-4:16 下午
 */
public class ScantterAndGrater {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        InetSocketAddress inetSocketAddress = new InetSocketAddress(9999);
        serverSocketChannel.socket().bind(inetSocketAddress);
        ByteBuffer[] byteBuffers = new ByteBuffer[2];
        byteBuffers[0] = ByteBuffer.allocate(5);
        byteBuffers[1] = ByteBuffer.allocate(3);

        SocketChannel accept = serverSocketChannel.accept();
        int messagelength =8;

        while (true){
            int byteRead = 0;
            while (byteRead <messagelength){
                long l = accept.read(byteBuffers);
                byteRead += l;
                System.out.println("byteRead:"+byteRead);
                Arrays.asList(byteBuffers).stream()
                        .map(buffer->"position="+buffer.position()+", limit="+buffer.limit())
                        .forEach(System.out::println);
            }
            Arrays.asList(byteBuffers).forEach(buffer -> buffer.flip());

            //将数据读出来，显示在客户端
            int byteWrite  = 0;
            while (byteWrite < messagelength){
                long write = accept.write(byteBuffers);
                byteWrite += write;
            }
        }
    }
}
