package com.cm.nio.groupchat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * @author cm
 * @create 2021/10/31-4:10 下午
 */
public class GroupChatServer {
    private Selector selector;
    private ServerSocketChannel listenChannel;
    private static int PORT = 6667;
    public GroupChatServer(){
        try {
            selector = Selector.open();
            listenChannel = ServerSocketChannel.open();
            //绑定端口
            listenChannel.socket().bind(new InetSocketAddress(PORT));
            //设置为非阻塞的
            listenChannel.configureBlocking(false);
            //将listenChannel绑定到selector上,监听到是连接到事件
            listenChannel.register(selector, SelectionKey.OP_ACCEPT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 监听连接事件
     */
    public void listen(){
        try {
           while (true){
               //2秒钟的时间
               int count = selector.select();
               if (count > 0){
                   //到这里说明有事件发生,获取所有key，并遍历这里key，看发生的是什么事件
                   Set<SelectionKey> selectionKeys = selector.selectedKeys();
                   Iterator<SelectionKey> iterator = selectionKeys.iterator();
                   while (iterator.hasNext()){

                       SelectionKey selectionKey = iterator.next();
                       if (selectionKey.isAcceptable()){
                           //进这里面说明是连接事件发生了
                           SocketChannel socketChannel = listenChannel.accept();
                           //注册到selector上面去，并设置为非阻塞状态的
                           socketChannel.configureBlocking(false);
                           socketChannel.register(selector,SelectionKey.OP_READ);
                           System.out.println(socketChannel.getRemoteAddress()+"上线了");
                       }
                       if (selectionKey.isReadable()){
                           //说明是读事件发生了，就用key获取对应的SocketChannel
                           readData(selectionKey);
                       }
                       iterator.remove();
                   }
               }else {
                   //到这里说明没有事件发生
                   System.out.println("等待。。。。。");
               }
           }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void readData(SelectionKey selectionKey){
        SocketChannel socketChannel = null;
        try {
            //通过key，获取到对应的socketChannel
            socketChannel = (SocketChannel) selectionKey.channel();
            //创建一个缓存区，读取channel里面的数据，然后放到buffer缓冲区里面
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            //读书数据，然后放到缓冲区里面
            int read = socketChannel.read(byteBuffer);
            if (read > 0){
                //进入到这里面，说明读取到了数据，将数据输出来
                String msg = new String(byteBuffer.array());
                System.out.println("from:"+socketChannel.getRemoteAddress()+"消息是："+msg);
                //然后还要将消息转发给其他客户端,这里获取所有到key，然后将自己给排除掉，然后再取出对应到数据
                sendInfoToOtherClients(msg,socketChannel);
            }
        }catch (Exception e){
           //这里可以通过异常来感知，有没有客户端在线了
            try {
                System.out.println(socketChannel.getRemoteAddress()+"客户端下线了");
                //取消注册，并且关闭相应的通道
                selectionKey.cancel();
                socketChannel.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }

    }

    /**
     * 转发消息到其他到客户段
     * @param msg 消息
     * @param self 发送消息到客户段，主要是用来排除自己的
     */
    private void sendInfoToOtherClients(String msg,SocketChannel self) throws IOException {
        System.out.println("服务器转发消息中。。。。");
        for (SelectionKey key : selector.keys()) {
            Channel targetChannel = key.channel();
            if (targetChannel instanceof SocketChannel && targetChannel != self){
                SocketChannel dest = (SocketChannel) targetChannel;
                //将数据写入buffer缓冲区，然后在从缓冲区写入到通道里面
                ByteBuffer buffer = ByteBuffer.wrap(msg.getBytes());
                dest.write(buffer);
            }
        }
    }
    public static void main(String[] args) {
        GroupChatServer groupChatServer = new GroupChatServer();
        groupChatServer.listen();
    }
}
