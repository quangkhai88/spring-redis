package com.tqk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.beans.factory.annotation.*;

/**
 * Created by khaitq
 * Date: 29/04/2018 - Paris, France
 * Github:  https://github.com/quangkhai88
 */

@org.springframework.context.annotation.Configuration
public class Configuration {


    @Value("${spring.redis.host}")
    private  String redisHost;

    @Value("${spring.redis.port}")
    private int redisPort;

    @Bean
    public JedisConnectionFactory connectionFactory() {

        System.out.println(redisHost);

        System.out.println(redisPort);

        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
        redisStandaloneConfiguration.setHostName(redisHost);
        redisStandaloneConfiguration.setPort(redisPort);

        return  new JedisConnectionFactory(redisStandaloneConfiguration);
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate() {

        RedisTemplate<String, Object> template =  new RedisTemplate<String, Object>();
        template.setConnectionFactory(connectionFactory());


        System.out.println(template);

        return template;
    }
}
