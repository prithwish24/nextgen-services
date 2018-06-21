package com.cts.product.profile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
//@EnableEurekaClient
//@EnableDiscoveryClient
//@EnableHystrix
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		/*new SpringApplicationBuilder(ProfileController.class, ConfigController.class)
		.bannerMode(Banner.Mode.OFF)
		.logStartupInfo(true)
		.run(args);*/
	}
}
