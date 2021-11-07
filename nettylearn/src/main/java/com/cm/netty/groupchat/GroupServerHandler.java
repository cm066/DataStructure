package com.cm.netty.groupchat;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author cm
 * @create 2021/11/7-9:28 下午
 * 这里有点像设计模式中的适配器模式
 */
public class GroupServerHandler extends SimpleChannelInboundHandler<String> {

    //用于管理所有的channle，并将添加的一个全局的执行器
   private static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

   //这个方法是第一个执行的  channel加入到 channelGroup让它管理起来，因为要用于消息的转发
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {

        Channel channel = ctx.channel();
        //在加入之前，应该遍历所有的channel，然后转发其上线的消息
        channelGroup.writeAndFlush("[客户端]:"+channel.remoteAddress()+"在"+sdf.format(new Date())+"加入了聊天\n");
        channelGroup.add(channel);
    }

    //处于一个活动状态
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(ctx.channel().remoteAddress()+"在:"+sdf.format(new Date())+"上线了\n");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(ctx.channel().remoteAddress()+"下线了\n");
    }
    //断开连接就会执行该方法
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        channelGroup.writeAndFlush(channel.remoteAddress()+"退出了群聊\n");
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        //在这里读取数据并且进行转发
        Channel channel = ctx.channel();
        //转发消息的时候要把自己给排除掉
        channelGroup.forEach(ch-> {
            if (ch != channel){
                //说明不是自己要进行消息的转发
                ch.writeAndFlush("[客户端]："+channel.remoteAddress()+"发送了消息："+msg+"\n");
            }else {
                ch.writeAndFlush("自己发送了消息："+msg+"\n");
            }
        });
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
       cause.printStackTrace();
       ctx.channel().close();
    }
}
