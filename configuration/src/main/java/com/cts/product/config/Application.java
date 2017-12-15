package com.cts.product.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

import com.cts.product.config.controller.RefreshController;

@SpringBootApplication
@EnableConfigServer
@EnableAutoConfiguration
//@EnableDiscoveryClient
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(RefreshController.class, args);
	}
}
