package com.qddx.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @Description: RabbitMQ配置
 * @Author: HUOHENGTONG
 * @CreateDate: 2019/4/14$ 16:46$
 */
@Configuration
public class RabbitMQConfig {
    //声明队列
    @Bean
    public Queue Queue() {
        return new Queue("topic.message");
    }

    //声明交换器
    @Bean
    public TopicExchange exchange() {
        return new TopicExchange("exchange");
    }

    //绑定
    @Bean
    public Binding binding(Queue queue,TopicExchange topicExchange){
        return BindingBuilder.bind(queue).to(topicExchange).with("topic.#");
    }
}
