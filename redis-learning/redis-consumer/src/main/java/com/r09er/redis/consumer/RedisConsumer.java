package com.r09er.redis.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 消费数据-处理者
 *
 * @author roger
 * @date 2020/3/1
 */
@Slf4j
@Component
public class RedisConsumer {

    public void onMessage(Object consumeObj,String topic) {
        log.info("消费数据...topic:{},消费数据内容:{}", topic, consumeObj);
    }

}
