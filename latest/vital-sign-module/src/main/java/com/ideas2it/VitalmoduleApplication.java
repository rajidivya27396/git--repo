package com.ideas2it;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.context.annotation.FilterType;
/**
 * Implementing vitalsignmodule
 *
 * @author Rajalakshmi
 */
@SpringBootApplication
@EnableFeignClients
@EnableTransactionManagement
@EnableJpaRepositories(includeFilters=@ComponentScan.Filter(type=FilterType.ASSIGNABLE_TYPE,classes=JpaRepository.class))
@EnableMongoRepositories(includeFilters=@ComponentScan.Filter(type=FilterType.ASSIGNABLE_TYPE,classes=MongoRepository.class))
public class VitalmoduleApplication {

	public static void main(String[] args) {
		SpringApplication.run(VitalmoduleApplication.class, args);
	}

}
