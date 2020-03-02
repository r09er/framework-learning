package redis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;

/**
 * @author roger
 * @date 2020/3/1
 */
@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<Object, Object> redisTemplate(RedisSerializer<Object> redisSerializer, RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<Object, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        template.setKeySerializer(RedisSerializer.string());
        template.setDefaultSerializer(redisSerializer);
        template.afterPropertiesSet();
        return template;
    }

    @Bean
    public RedisSerializer<Object> redisSerializer(){
        GenericJackson2JsonRedisSerializer redisSerializer = new GenericJackson2JsonRedisSerializer();
        return redisSerializer;
    }
}
