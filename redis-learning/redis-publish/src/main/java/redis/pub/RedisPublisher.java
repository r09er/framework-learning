package redis.pub;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author roger
 * @date 2020/3/1
 */
@EnableScheduling
@Component
public class RedisPublisher {

    private static final Logger log = LoggerFactory.getLogger(RedisPublisher.class);

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    private AtomicInteger incrInteger = new AtomicInteger();


    @Scheduled(initialDelay = 500, fixedDelay = 10000)
    public void publish() {
        int incrementAndGet = incrInteger.incrementAndGet();
        String topic = "redis/test";
        String message = "current num : " + incrementAndGet;
        log.info("发布消息..topic:{},内容:{}", topic, message);
        redisTemplate.convertAndSend(topic, message);
    }
}
