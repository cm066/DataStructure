package com.cm.netty.rpc.consumer;

import com.cm.netty.rpc.common.HelloService;
import com.cm.netty.rpc.netty.NettyClient;

/**
 * @author cm
 * @create 2021/11/13-10:08 下午
 */
public class ClientBootstrap {

    public static final String providerName = "HelloService#hello#";
    public static void main(String[] args) {
        NettyClient client = new NettyClient();
        HelloService service = (HelloService) client.getBean(HelloService.class, providerName);
        String res = service.hello("你好 dubbo~");
        System.out.println("服务器返回的结果是："+res);
    }
}
