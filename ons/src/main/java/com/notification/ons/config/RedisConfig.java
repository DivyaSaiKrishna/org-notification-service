package com.notification.ons.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

import java.time.Duration;

@Configuration
public class RedisConfig {

    @Bean
    public LettuceConnectionFactory redisConnectionFactory() {

        RedisStandaloneConfiguration redisConfig =
                new RedisStandaloneConfiguration(
                        System.getenv("REDIS_HOST"),
                        Integer.parseInt(System.getenv("REDIS_PORT"))
                );

        redisConfig.setUsername(System.getenv("REDIS_USERNAME"));
        redisConfig.setPassword(System.getenv("REDIS_PASSWORD"));

        LettuceClientConfiguration clientConfig =
                LettuceClientConfiguration.builder()
                        .commandTimeout(Duration.ofSeconds(5))
                        .useSsl()
                        .build();

        return new LettuceConnectionFactory(redisConfig, clientConfig);
    }
}
