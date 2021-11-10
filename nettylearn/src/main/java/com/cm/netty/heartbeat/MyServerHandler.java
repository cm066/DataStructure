package com.cm.netty.heartbeat;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleStateEvent;

/**
 * @author cm
 * @create 2021/11/8-10:46 下午
 */
public class MyServerHandler extends ChannelInboundHandlerAdapter {
    /**
     * 这个是心跳检查后，会触发的方法
     * @param ctx 上下文
     * @param evt 触发的事件
     * @throws Exception 发生的异常
     */
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent){
            IdleStateEvent idleStateEvent = (IdleStateEvent) evt;
            String eventType = null;
            switch (idleStateEvent.state()){
                case READER_IDLE:
                    eventType = "读空闲";
                    break;
                case WRITER_IDLE:
                    eventType = "写空闲";
                    break;
                case ALL_IDLE:
                    eventType = "读写空闲";
                    break;
            }
            System.out.println(ctx.channel().remoteAddress()+"超时事件是："+ eventType);
            System.out.println("服务器根据相关事件做出反应");
        }
    }
}
