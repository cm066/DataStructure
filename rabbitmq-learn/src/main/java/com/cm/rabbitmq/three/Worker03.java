package com.cm.rabbitmq.three;

import com.cm.rabbitmq.utils.RabbitMqUtils;
import com.cm.rabbitmq.utils.SleepUtils;
import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

/**
 * 消息在手动应答是是不丢失，放回队列中重新消费
 */
public class Worker03 {
    public static final String TASK_QUEUE_NAME = "ack_queue";

    public static void main(String[] args) throws IOException, TimeoutException {
        Channel channel = RabbitMqUtils.getChannel();
        System.out.println("C2等待接收消息处理时间较长");

        //声明 接收消息
        DeliverCallback deliverCallback = (consumerTag, message) -> {
            SleepUtils.sleep(30);
            System.out.println("接收到的消息：" + new String(message.getBody(), StandardCharsets.UTF_8));

            /**
             * 手动应答
             * 1、消息的标记 tag
             * 2、是否批量应答 false；不批量应答信道中的消息 true:批量
             */
            channel.basicAck(message.getEnvelope().getDeliveryTag(), false);
        };
//        int prefetchCount = 1;//设置为不公平分发，默认采用的是轮询的方式来
        int prefetchCount = 5;//预取值
        channel.basicQos(prefetchCount);
        //取消消息时的回调、
        CancelCallback cancelCallback = consumerTag -> {
            System.out.println(consumerTag + "消息消费被中断");
        };
        //采用手动应答
        boolean autoAck = false;
        channel.basicConsume(TASK_QUEUE_NAME, autoAck, deliverCallback, cancelCallback);
    }
}
