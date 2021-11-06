package com.cm.netty.simple;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

/**
 * @author cm
 * @create 2021/11/6-10:37 上午
 */
public class NettyClientHandler extends ChannelInboundHandlerAdapter {

    //通道建立连接就会执行该方法中
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("client :"+ctx);
        ctx.writeAndFlush(Unpooled.copiedBuffer("hello 服务端，我是001客户端", CharsetUtil.UTF_8));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("客户端发生了异常了,异常消息是:"+cause.getMessage());
        cause.printStackTrace();
        ctx.close();
    }

    //读取消息,有读的事件来了，才会执行该方法，因为netty本身就是基于事件驱动发生的
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf) msg;
        System.out.println("收到来自客户端的消息："+byteBuf.toString(CharsetUtil.UTF_8));
    }
}
