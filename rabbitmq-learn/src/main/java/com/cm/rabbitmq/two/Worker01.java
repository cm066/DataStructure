package com.cm.rabbitmq.two;

import com.cm.rabbitmq.utils.RabbitMqUtils;
import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 这是一个工作线程，相当于之前消费者
 */
public class Worker01 {
    public static final String QUEUE_NAME = "hello";

    public static void main(String[] args) throws IOException, TimeoutException {
        Channel channel = RabbitMqUtils.getChannel();

        //声明 接收消息
        DeliverCallback deliverCallback = (consumerTag, message) -> {
            System.out.println("接收到的消息：" + message.getBody().toString());
        };

        //取消消息时的回调、
        CancelCallback cancelCallback = consumerTag -> {
            System.out.println(consumerTag + "消息消费被中断");
        };
        System.out.println("C2等待接收消息");
        //消息接
        channel.basicConsume(QUEUE_NAME, true, deliverCallback, cancelCallback);
    }
}
