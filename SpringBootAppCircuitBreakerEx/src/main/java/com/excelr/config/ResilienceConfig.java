package com.excelr.config;

import java.time.Duration;

import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;

@Configuration
public class ResilienceConfig {
	@Bean
	public Customizer<Resilience4JCircuitBreakerFactory> defaultCustomizer() {
	    return factory -> factory.configureDefault(id -> new Resilience4JConfigBuilder(id)
	            .circuitBreakerConfig(CircuitBreakerConfig.custom()
	                .failureRateThreshold(50)
	                .waitDurationInOpenState(Duration.ofSeconds(10))
	                .slidingWindowSize(10)
	                .permittedNumberOfCallsInHalfOpenState(3)
	                .build())
	            .build());
	}

}