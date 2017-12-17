package com.cts.product.gateway.config;

import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HystrixFallbackConfiguration {

	@Bean
	public ZuulFallbackProvider profileServiceFallbackProvider() {
		return new FallbackProvider("PROFILE-SERVICE");
	}
	
	@Bean
	public ZuulFallbackProvider reservationServiceFallbackProvider() {
		return new FallbackProvider("RESERVATION-SERVICE");
	}
	
}
