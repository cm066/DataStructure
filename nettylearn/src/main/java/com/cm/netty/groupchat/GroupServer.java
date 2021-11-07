package com.cm.netty.groupchat;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * @author cm
 * @create 2021/11/7-9:19 下午
 */
public class GroupServer {
    private int port;
    public GroupServer(int port){
        this.port = port;
    }

    public void run() throws InterruptedException {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workGroup = new NioEventLoopGroup();
        ServerBootstrap bootstrap = new ServerBootstrap();

        try {
            bootstrap.group(bossGroup,workGroup)
                    //这个是绑定socketchannel
                    .channel(NioServerSocketChannel.class)
                    //这个是连接数队列的大小
                    .option(ChannelOption.SO_BACKLOG,128)
                    //这个是workGroup里面的eventLoop线程里面的连接设置为长连接操作
                    .childOption(ChannelOption.SO_KEEPALIVE,true)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            //可以在这里面添加handler处理器，就是workGroup线程里面的piple管道
                            ChannelPipeline pipeline = ch.pipeline();
                            //可以在这里面进行编码和解码的操作，也可以进行其他的业务操作
                            pipeline.addLast("decoder",new StringDecoder())
                                    .addLast("encoder",new StringEncoder())
                                    //这个是自定义的业务处理器
                                    .addLast(new GroupServerHandler());
                        }
                    });
            System.out.println("netty server is reading");
            ChannelFuture channelFuture = bootstrap.bind(port).sync();
            //监听关闭事件
            channelFuture.channel().closeFuture().sync();
        } finally {
            //关闭bossGroup和workGroup
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }
    }
    public static void main(String[] args) throws InterruptedException {
        GroupServer server = new GroupServer(6667);
        server.run();
    }
}
