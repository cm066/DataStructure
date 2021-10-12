package com.cm.rabbitmq.two;

import com.cm.rabbitmq.utils.RabbitMqUtils;
import com.rabbitmq.client.Channel;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

public class Task01 {
    public static final String QUEUE_NAME = "hello";

    public static void main(String[] args) throws IOException, TimeoutException {
        Channel channel = RabbitMqUtils.getChannel();
        /**
         * 生成一个队列
         * 1、队列名称
         * 2、队列里面的消息是否持久化，默认是不持久化的
         * 3、该队列是否只供一个消费者进行消费，是否共享，true为共享
         * 4、是否自动删除，最后一个消费这端开连接以后，该队一句是否自动删除
         * 5、其它参数
         */
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        String message = "hello world";
        /**
         * 发送一个消费
         * 1、发送到那个交换机
         * 2、路由的key值是哪一个 本次是队列的名称
         * 3、其他参数
         * 4、发送消息的消息体
         */
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String next = scanner.next();
            channel.basicPublish("", QUEUE_NAME, null, next.getBytes());
            System.out.println("消息发送完毕" + next);
        }


    }
}
