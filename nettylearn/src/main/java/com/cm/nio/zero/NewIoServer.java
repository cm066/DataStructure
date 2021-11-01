package com.cm.nio.zero;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @author cm
 * @create 2021/11/2-12:12 上午
 */
public class NewIoServer {
    public static void main(String[] args) throws IOException {
        InetSocketAddress inetSocketAddress = new InetSocketAddress(7001);
        SocketChannel socketChannel = SocketChannel.open();
        Socket socket = socketChannel.socket();
        socket.bind(inetSocketAddress);
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
    }
}
