package com.cm.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @author cm
 * @create 2021/10/31-3:28 下午
 */
public class NIOClient {
    public static void main(String[] args) throws IOException {
        //得到一个网络通道
        SocketChannel socketChannel = SocketChannel.open();
        //设置为非阻塞的
        socketChannel.configureBlocking(false);
        InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1",6666);

        if (!socketChannel.connect(inetSocketAddress)){
            //这里是在证明当连接还没有连接好的时候，可以去做其他的，还不是在这里阻塞着
            while (!socketChannel.finishConnect()){
                System.out.println("网络连接需要时间，现在还没有连接好，你可以做其他的事情");
            }
        }
        String s = "陈明，你好呀！";
        //要绑定一个bytebuffer
        ByteBuffer buffer = ByteBuffer.wrap(s.getBytes());
        //将buffer缓冲区里面的数据，写入到socketchanal通道里面去
        socketChannel.write(buffer);
        //是程序阻塞在这里
        System.in.read();
    }
}
