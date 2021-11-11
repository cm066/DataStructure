package com.cm.netty.protocol;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.nio.charset.Charset;
import java.util.UUID;

/**
 * @author cm
 * @create 2021/11/11-11:36 下午
 */
public class MyServerHandler extends SimpleChannelInboundHandler<MessageProtocol> {
    private int count;
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("发生了异常："+cause.getMessage());
        ctx.close();
    }


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageProtocol msg) throws Exception {
        int len = msg.getLen();
        byte[] content = msg.getContent();
        System.out.println("服务器接收到消息如下");
        System.out.println("长度="+len);
        System.out.println("内容是："+new String(content, Charset.forName("utf-8")));
        System.out.println("服务器接收到的消息包数量是："+(++count));
        String responseMessage = UUID.randomUUID().toString();
        byte[] messageBytes = responseMessage.getBytes(Charset.forName("utf-8"));
        int length = responseMessage.getBytes("utf-8").length;
        MessageProtocol messageProtocol = new MessageProtocol();
        messageProtocol.setLen(length);
        messageProtocol.setContent(messageBytes);
        ctx.writeAndFlush(messageBytes);
    }
}
