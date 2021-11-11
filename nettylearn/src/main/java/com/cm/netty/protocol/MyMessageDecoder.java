package com.cm.netty.protocol;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;

import java.util.List;

/**
 * @author cm
 * @create 2021/11/11-11:28 下午
 */
public class MyMessageDecoder extends ReplayingDecoder<Void> {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        System.out.println("message decode  被调用了");
        int length = in.readInt();

        byte[] content = new byte[length];
        in.readBytes(content);
        //将消息封装成自己想要的，然后放进out对象里面去，交给下一个handler处理器处理
        MessageProtocol messageProtocol = new MessageProtocol();
        messageProtocol.setLen(length);
        messageProtocol.setContent(content);
        out.add(messageProtocol);
    }
}
