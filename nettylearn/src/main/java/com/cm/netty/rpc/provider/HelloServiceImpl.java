package com.cm.netty.rpc.provider;

import com.cm.netty.rpc.common.HelloService;

/**
 * @author cm
 * @create 2021/11/13-5:56 下午
 */
public class HelloServiceImpl implements HelloService {

    /**
     * 服务的提供则者，后面根据反射来创建
     * @param msg
     * @return
     */
    @Override
    public String hello(String msg) {
        System.out.println("收到客户端消息："+msg);
        String message = "我收到消息："+msg+"现在给你反馈信息";
        if (msg != null){
            return "我收到消息："+msg+"现在给你反馈信息";
        }else {
            return "你好，客户端：我现在给你反馈消息";
        }

    }
}
