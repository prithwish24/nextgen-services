package com.cts.product.gateway;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@EnableHystrix
@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		new SpringApplicationBuilder(
	            Application.class) 
	            .web(true).run(args);
	}
	
	/*@Bean
	public GatewayPreFilter getwayPreFilter() {
		return new GatewayPreFilter();
	}*/
}
