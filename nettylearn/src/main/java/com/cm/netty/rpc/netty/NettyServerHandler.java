package com.cm.netty.rpc.netty;

import com.cm.netty.rpc.provider.HelloServiceImpl;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author cm
 * @create 2021/11/13-7:49 下午
 */
public class NettyServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("有一个客户端来连接，连接成功");
//        ctx.writeAndFlush("hhhhhh");
    }

    /**
     * 定义协议，然后客户端和服务端都需要遵守这个协议，否则就是报错
     */

    public static final String PROTOCOL = "HelloService#hello#";

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //获取客户端发送的消息，并调用我们的服务
        System.out.println("msg="+msg);
        //要规定自己的协议 调用服务器api的时候要遵守协议
        //比如我们要求传入的是 这个就是要调用那个类#方法名#参数
        if(msg.toString().startsWith(PROTOCOL)){
            //最主要的还是这个参数怎么取过来，然后调用那个类，那个方法
            String hello = new HelloServiceImpl().hello(msg.toString().substring(msg.toString().lastIndexOf("#") + 1));
            System.out.println(hello);
            ctx.writeAndFlush(hello);
        }

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("发生了异常，异常消息是："+cause.getMessage());
        //关闭通道
        ctx.close();
    }
}
