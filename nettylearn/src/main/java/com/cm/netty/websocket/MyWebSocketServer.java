package com.cm.netty.websocket;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * @author cm
 * @create 2021/11/8-11:25 下午
 * 基于http 的websocket长连接开发
 * */
public class MyWebSocketServer {
    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup workGroup = new NioEventLoopGroup();
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup,workGroup)
                    .channel(NioServerSocketChannel.class)
                    .handler(new LoggingHandler(LogLevel.INFO))
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            //基于http的编码和解码
                            pipeline.addLast(new HttpServerCodec())
                                    //以块的方式
                                    .addLast(new ChunkedWriteHandler())
                                    //将多个http块聚合在一起
                                    .addLast(new HttpObjectAggregator(8192))
                                    //在 websocket编程中是以帧（frame)的形式传递的
                                    //ws://localhost:7000/hello
                                    //WebSocketServerProtocolHandler 核心功能是将http协议升级为ws 长连接
                                    //ws://localhost:7000/hello
                                    .addLast(new WebSocketServerProtocolHandler("/hello"))
                                    //然后添加自己的业务处理器
                                    .addLast(new MyWebSocketServerHandler());
                        }
                    });
            ChannelFuture channelFuture = serverBootstrap.bind(7001).sync();
            channelFuture.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }
    }
}
