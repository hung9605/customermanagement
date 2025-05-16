package com.app.customermanagement.config;

import java.time.Duration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

@Configuration
@EnableCaching
public class RedisConfig {
	@Configuration
	@EnableCaching
	public class DynamicCacheConfig {

	    @Bean
	    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
	        try {
	            // Thử kết nối Redis (timeout ngắn để tránh chậm start)
	            redisConnectionFactory.getConnection().ping();
	            System.out.println("✅ Connected to Redis - using RedisCacheManager");

	            RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig()
	                    .entryTtl(Duration.ofMinutes(30))
	                    .serializeValuesWith(RedisSerializationContext.SerializationPair
	                            .fromSerializer(new GenericJackson2JsonRedisSerializer()));

	            return RedisCacheManager.builder(redisConnectionFactory)
	                    .cacheDefaults(config)
	                    .build();
	        } catch (Exception ex) {
	            System.out.println("⚠️ Redis not available - falling back to ConcurrentMapCacheManager");
	            System.out.println(ex);
	            return new ConcurrentMapCacheManager(); // RAM cache
	        }
	    }
	}

}