package com.cm.netty.rpc.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.lang.reflect.Proxy;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author cm
 * @create 2021/11/13-9:47 下午
 */
public class NettyClient {

    /**
     * 创建线程池
     */
    private static ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    private static NettyClientHandler clientHandler;

    /**
     * 编写方法使用代理，来获取一个代理对象
     */
    public Object getBean(final Class<?> serviceClass,final  String provideName){

        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                new Class<?>[] {serviceClass},(proxy,method,args) -> {
            //客户端每调用一次，就会进入到这里
            if (clientHandler == null){

                initClient();
            }
            //设置要发送给服务器的消息
                    clientHandler.setPara(provideName+args[0]);
            return executorService.submit(clientHandler).get();
        });
    }

    /**
     * 初始化客户端
     */
    private static void initClient(){
        clientHandler = new NettyClientHandler();

        NioEventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group)
                    .channel(NioSocketChannel.class)
                    //设置为没有延迟的
//                    .option(ChannelOption.TCP_NODELAY,true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast(new StringDecoder())
                                    .addLast(new StringEncoder())
                                    .addLast(clientHandler);
                        }
                    });
            ChannelFuture channelFuture = bootstrap.connect("127.0.0.1", 7002).sync();
            //一定要写这一个，不然执行完就回去执行finall里面的代码，然而在finall关闭了通道，导致连接失败
            channelFuture.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully();
        }

    }
}
