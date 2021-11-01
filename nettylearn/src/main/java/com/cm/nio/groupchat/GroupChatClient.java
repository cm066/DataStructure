package com.cm.nio.groupchat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author cm
 * @create 2021/10/31-7:16 下午
 */
public class GroupChatClient {
    private static final String HOST ="127.0.0.1";
    private static final int PORT =  6667;
    private Selector selector;
    private SocketChannel socketChannel;
    private String userName;
    public GroupChatClient() throws IOException {
        //得到selector
        selector = Selector.open();
        //获取连接
        socketChannel = SocketChannel.open(new InetSocketAddress(HOST,PORT));
        //设置为非阻塞的
        socketChannel.configureBlocking(false);
        //监听read事件
        socketChannel.register(selector, SelectionKey.OP_READ);
        userName = socketChannel.getLocalAddress().toString().substring(1);
        System.out.println(userName+"...is ok");
    }

    /**
     * 发送消息的方法
     * @param info 发送的消息
     */
    private void sendInfo(String info){
        info = userName +":说："+info;
        try {
            socketChannel.write(ByteBuffer.wrap(info.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 读取从客户端发送过来的消息
     */
    private void readInfo(){

        try {
            int select = selector.select();
            if (select > 0){
                //进入这里说明有事件发生
                Set<SelectionKey> keys = selector.keys();
                Iterator<SelectionKey> iterator = keys.iterator();
                while (iterator.hasNext()){
                    SelectionKey key = iterator.next();
                    //得到相应的key，然后判断发生的是什么事件
                    if (key.isReadable()){
                        //说明发生的是read事件，获取对应的channel，然后把channel里面的数据读取到buffer里面
                        SocketChannel socketChannel = (SocketChannel) key.channel();
                        //创建一个1024字节的缓冲区
                        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                        socketChannel.read(byteBuffer);
                        String msg = new String(byteBuffer.array());
                        System.out.println(msg.trim());
                    }
                    //移除key，防止重复操作
                    iterator.remove();
                }

            }else {
                System.out.println("没有通道可以用了");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws IOException {
        GroupChatClient chatClient = new GroupChatClient();

        //启动一个线程一直去读取消息
        new Thread(){
            @Override
            public void run(){
                chatClient.readInfo();
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            String s = scanner.nextLine();
            chatClient.sendInfo(s);
        }
    }
}
