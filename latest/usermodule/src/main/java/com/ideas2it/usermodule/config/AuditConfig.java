package com.ideas2it.usermodule.config;

import java.util.Optional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.context.SecurityContextHolder;

@Configuration
@EnableJpaAuditing(auditorAwareRef="auditProvider")
public class AuditConfig {
    @Bean
	public AuditorAware<String> auditProvider() {
    	return ()-> Optional.of(SecurityContextHolder.getContext().getAuthentication().getName());
	}
}
