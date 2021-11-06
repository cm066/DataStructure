package com.cm.netty.simple;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;


/**
 * @author cm
 * @create 2021/11/6-9:41 上午
 */
public class NeetyServer {
    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup,workGroup)
                    .channel(NioServerSocketChannel.class)
                    //这里就相当于是bossGroup里面的任务队列数，当处理处理完成后就去队列任务数里面拿
                    .option(ChannelOption.SO_BACKLOG,128)
                    .childOption(ChannelOption.SO_KEEPALIVE,true)
                    //这里就相当于channel注册到了workGroup里面，让他们建立起了连接
                   .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            //这里就是把自定义的处理器，加入到channel中去，进行自定义的业务逻辑处理
                            ch.pipeline().addLast(new NettyServerHandler());
                        }
                    });
            System.out.println("netty 服务启动了");
            ChannelFuture channelFuture = serverBootstrap.bind(6667).sync();
            //关闭服务器
            channelFuture.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }
    }
}
