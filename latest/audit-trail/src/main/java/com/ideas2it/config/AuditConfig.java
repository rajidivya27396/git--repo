package com.ideas2it.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.ideas2it.dto.AuditDto;

@Configuration
@EnableKafka
public class AuditConfig {

	/**
	 * Audit config implementation for vital module
	 */
	@Bean
	public ConsumerFactory<String, AuditDto> vitalConsumerFactory() {
		JsonDeserializer<AuditDto> deserializer = new JsonDeserializer<>(AuditDto.class);
	    // deserializer.setRemoveTypeHeaders(false);
	    deserializer.addTrustedPackages("*");
	    // deserializer.setUseTypeMapperForKey(true);
	    Map<String, Object> configs = new HashMap<>();
		configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, deserializer);
		configs.put(ConsumerConfig.GROUP_ID_CONFIG, "group-1");
		configs.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
		return new DefaultKafkaConsumerFactory<>(configs, new StringDeserializer(), deserializer);
	}
	
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, AuditDto> vitalKafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, AuditDto> factory = new ConcurrentKafkaListenerContainerFactory<String, AuditDto>();
		factory.setConsumerFactory(vitalConsumerFactory());
		return factory;
	}
	
	/**
	 * Audit config implementation for patient module
	 */
	@Bean
	public ConsumerFactory<String, AuditDto> patientConsumerFactory() {
		JsonDeserializer<AuditDto> deserializer = new JsonDeserializer<>(AuditDto.class);
	    deserializer.addTrustedPackages("*");
	    Map<String, Object> configs = new HashMap<>();
		configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, deserializer);
		configs.put(ConsumerConfig.GROUP_ID_CONFIG, "group-2");
		configs.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
		return new DefaultKafkaConsumerFactory<>(configs, new StringDeserializer(), deserializer);
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, AuditDto> patientKafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, AuditDto> factory = new ConcurrentKafkaListenerContainerFactory<String, AuditDto>();
		factory.setConsumerFactory(patientConsumerFactory());
		return factory;
	}
	

	/**
	 * Audit config implementation for user module
	 */
	@Bean
	public ConsumerFactory<String, AuditDto> userConsumerFactory() {
		JsonDeserializer<AuditDto> deserializer = new JsonDeserializer<>(AuditDto.class);
	    deserializer.addTrustedPackages("*");
	    Map<String, Object> configs = new HashMap<>();
		configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, deserializer);
		configs.put(ConsumerConfig.GROUP_ID_CONFIG, "group-3");
		configs.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
		return new DefaultKafkaConsumerFactory<>(configs, new StringDeserializer(), deserializer);
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, AuditDto> userKafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, AuditDto> factory = new ConcurrentKafkaListenerContainerFactory<String, AuditDto>();
		factory.setConsumerFactory(userConsumerFactory());
		return factory;
	}
}
