package com.cm.netty.rpc.provider;

import com.cm.netty.rpc.netty.NettyServer;

/**
 * @author cm
 * @create 2021/11/13-7:36 下午
 * 服务提供者的启动类
 */
public class ProviderServerBootstrap {
    public static void main(String[] args) {
        NettyServer.startServer("127.0.0.1",7002);
    }
}
