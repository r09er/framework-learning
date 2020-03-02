package com.r09er.redis.config;

import com.r09er.redis.consumer.RedisConsumer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.RedisSerializer;

/**
 * @author roger
 * @date 2020/3/1
 */
@Configuration
public class ConsumerConfig {

    @Bean
    public MessageListenerAdapter processorOne(RedisSerializer<Object> serializer, RedisConsumer redisConsumer) {

        MessageListenerAdapter adapter = new MessageListenerAdapter(redisConsumer, "onMessage");
        adapter.setSerializer(serializer);
        return adapter;
    }

    /**
     * 负责所有线程的消息接收和派遣到侦听器进行处理,内部线程池管理所有的消息分发和处理,即使订阅的是不同topic
     * 支持动态添加监听
     *
     * @param adapter
     * @return
     */
    @Bean
    public RedisMessageListenerContainer messageListenerContainer(RedisConnectionFactory redisConnectionFactory,
                                                                  MessageListenerAdapter adapter) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(redisConnectionFactory);
        container.setTopicSerializer(RedisSerializer.string());
        container.addMessageListener(adapter, new PatternTopic("redis/**"));
        return container;
    }

}
