package com.nettylearn.start;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 * @author cm
 * @create 2021/10/26-12:45 上午
 */
public class ServerBootTest {
//    private  final  static Logger logger = LoggerFactory.getLogger(ServerBootTest.class);
    public static void main(String[] args) throws InterruptedException {

        //1、创建一个线程组用来处理网络事件（接受客户端连接）
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        //2、创建一个线程组用来处理网络事件（处理通道 I/O 读写事件）
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();
        ServerBootstrap b =  new ServerBootstrap();
//        IntegerToString

        try {
            b.group(bossGroup,workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG,100)
                    .handler(new LoggingHandler(LogLevel.INFO))
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline p = ch.pipeline();
                            p.addLast(new LoggingHandler(LogLevel.INFO));
                        }
                    });
            ChannelFuture f = b.bind(9999).sync();
            f.channel().closeFuture().addListeners(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture future) throws Exception {
                    System.out.println(future.channel().toString()+"链路关闭");
                }
            }).sync();
//            f.channel().closeFuture().addListener(new ChannelFutureListener() {
//                @Override
//                public void operationComplete(ChannelFuture future) throws Exception {
//                    System.out.println(future.channel().toString()+"链路关闭");
//                }
//            });
        }finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }

    }
}
