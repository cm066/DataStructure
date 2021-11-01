package com.cm.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author cm
 * @create 2021/10/30-11:36 下午
 */
public class NIOServer {
    public static void main(String[] args) throws IOException {
        //ServerSocketChannel --> ServerSocket
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //获取一个sellector
        Selector selector = Selector.open();
        //绑定一个端口在服务器监听
        serverSocketChannel.socket().bind(new InetSocketAddress(6666));
        //设置为非堵塞
        serverSocketChannel.configureBlocking(false);
        //将serverSocketChannel 注册selector上
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        //等待客户端连接
        while (true){
            //我们等待一秒，如果没有事件发生2就返回
            if (selector.select(1000) == 0){
                System.out.println("我们等待了 1秒,没有连接");
                continue;
            }
            //如果大于0，就获取发生事件的相关key
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()){
                SelectionKey key = iterator.next();
                //说明是连接事件
                if (key.isAcceptable()){
                    //给连接生成一个对应的SocketChannel，这里为什么不是阻塞的，是因为这里连接已经来了，而原来的是阻塞
                    //在这里，等到连接的到来
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    //这里还需要socketchannel 设置为非阻塞的
                    socketChannel.configureBlocking(false);
                    //将这个 socketChannel绑定在selector上，并关注read事件的发生，并且还绑定一个bytebuffer在这上面
                    socketChannel.register(selector,SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                }
                //发生的是读事件
                if (key.isReadable()){
                    //通过key反向的获取socketChannel
                    SocketChannel channel = (SocketChannel) key.channel();
                    //然后在获取到绑定在这个socketChannel上的bytebuffer
                    ByteBuffer byteBuffer = (ByteBuffer) key.attachment();
                    System.out.println("from 客户端来的数据是："+new String(byteBuffer.array()));
                }
                //防止在多线程的情况下重复操作
                iterator.remove();
            }
        }
    }
}
