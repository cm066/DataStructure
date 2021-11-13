package com.cm.netty.rpc.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.concurrent.Callable;

/**
 * @author cm
 * @create 2021/11/13-8:18 下午
 */
public class NettyClientHandler extends ChannelInboundHandlerAdapter implements Callable {
    /**
     * context 上下文
     * result 远程调用返回来的结果
     * para 调用传入的参数
     */
    private ChannelHandlerContext context;
    private String result;
    private String para;

    /**
     *  与服务器连接创建后
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        context = ctx;
        ctx.writeAndFlush("HelloService#hello#"+"你好 dubbo~");
        System.out.println("和服务端连接成功");
    }

    /**
     * 收到服务器消息后，调用方法，并唤醒线程
     * 这里有两个问题不是很明白，就是唤醒线程，这里的调用流程是什么
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public synchronized void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        result = msg.toString();
        System.out.println("接收到服务端返回来的消息是："+result);
        //唤醒等待的线程
        notify();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("发生了异常："+cause.getMessage());
        cause.printStackTrace();
        ctx.close();
    }


    /**
     * 实现这个方法的意义是什么？
     * 被代理对象调用，发送数据给服务器---> wait---->然后等待被唤醒
     * @return
     * @throws Exception
     */
    @Override
    public synchronized Object call() throws Exception {
//        System.out.println(para);
        //发送消息给服务器
        context.writeAndFlush(para);
        //等待服务器返回结果后唤醒线程
        System.out.println(context);
        wait();
        return result;
    }

    public String getPara() {
        return para;
    }

    public void setPara(String para) {
        this.para = para;
    }
}
