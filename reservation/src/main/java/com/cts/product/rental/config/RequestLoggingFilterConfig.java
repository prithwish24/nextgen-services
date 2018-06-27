package com.cts.product.rental.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

@Configuration
public class RequestLoggingFilterConfig {

	@Bean
	public CommonsRequestLoggingFilter requestLoggingFilter () {
		CommonsRequestLoggingFilter rlf = new CommonsRequestLoggingFilter();
		rlf.setIncludeClientInfo(true);
		rlf.setIncludeQueryString(true);
		rlf.setIncludePayload(true);
		return rlf;
	}
}
