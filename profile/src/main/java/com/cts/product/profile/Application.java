package com.cts.product.profile;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.cts.product.profile.controller.ConfigController;
import com.cts.product.profile.controller.ProfileController;

@SpringBootApplication
@EnableDiscoveryClient
public class Application {
	public static void main(String[] args) {
		//SpringApplication.run(ProfileController.class, args);
		new SpringApplicationBuilder(ProfileController.class, ConfigController.class)
		.bannerMode(Banner.Mode.OFF)
		.logStartupInfo(true)
		.run(args);
	}
}
