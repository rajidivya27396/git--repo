package com.ideas2it.usermodule.config;

import java.util.HashMap;
import java.util.Map;
import java.time.Duration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext.SerializationPair;

@Configuration
@EnableCaching
public class CacheConfig {
	@Bean
	public RedisCacheManager getRedisCacheManager(RedisConnectionFactory connectionFactory) {
		RedisCacheWriter cacheWriter = RedisCacheWriter.lockingRedisCacheWriter(connectionFactory);
		ClassLoader loader = this.getClass().getClassLoader();
		JdkSerializationRedisSerializer jdkSerializer = new JdkSerializationRedisSerializer(loader);
		SerializationPair<Object> pair = SerializationPair.fromSerializer(jdkSerializer);

		RedisCacheConfiguration cacheConfig = RedisCacheConfiguration.defaultCacheConfig().serializeValuesWith(pair);
		cacheConfig = cacheConfig.entryTtl(Duration.ofSeconds(3600));

		Map<String, RedisCacheConfiguration> initialCacheConfigurations = new HashMap<>();
		initialCacheConfigurations.put("usercache", cacheConfig.entryTtl(Duration.ofSeconds(1600)));

		RedisCacheManager cacheManager = new RedisCacheManager(cacheWriter, cacheConfig, initialCacheConfigurations);

		return cacheManager;
}
}