package rabbitmq.simple;

import com.rabbitmq.client.*;
import rabbitmq.util.ConnectionUtil;

import java.io.IOException;

public class Recv {

    private final static String QUEUE_NAME = "test_queue";

    public static void main(String[] argv) throws Exception {

        // 获取到连接以及mq通道
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        // 声明队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        // 定义队列的消费者、获取消息
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
                    throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println(" [x] Received '" + message + "'");
            }
        };
        // 监听队列
        channel.basicConsume(QUEUE_NAME, true, consumer);
    }
}
