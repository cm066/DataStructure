package com.cm.netty.simple;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

import java.util.concurrent.TimeUnit;

/**
 * @author cm
 * @create 2021/11/6-10:09 上午
 */
public class NettyServerHandler extends ChannelInboundHandlerAdapter {


    //这个是接收数据
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        /**
         * 这个就是把任务提交到taskqueue里面去，不会阻塞下面方法的执行，这里就相当于是异步执行的
         * 然后可以在这里面提交多个任务到taskQueue里面去 这里是程序定义到普通任务
         */
        ctx.channel().eventLoop().execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10*1000);
                    ctx.writeAndFlush(Unpooled.copiedBuffer("我是睡眠10秒以后发送的消息给你",CharsetUtil.UTF_8));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        //方案2 用户可以自定义任务 但是不是放在taskQueue这个任务队列里面到
        ctx.channel().eventLoop().schedule(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10*1000);
                    ctx.writeAndFlush(Unpooled.copiedBuffer("我是自定义任务队列到消息",CharsetUtil.UTF_8));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },5, TimeUnit.SECONDS);
        System.out.println("go on");
        System.out.println(Thread.currentThread().getName());
        System.out.println("server ctx is:"+ctx);
        ByteBuf byteBuf = (ByteBuf) msg;
        System.out.println("来自客户端到消息是："+byteBuf.toString(CharsetUtil.UTF_8));
        System.out.println("客户端到地址是："+ctx.channel().remoteAddress());
    }

    //这个是发送数据
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(Unpooled.copiedBuffer("hello ,客户端",CharsetUtil.UTF_8));
    }

    //这个是发生异常执行的方法
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("发生了异常:"+cause.getMessage());
        cause.printStackTrace();
        ctx.close();
    }

}
