package com.cts.product.addone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cts.product.addone.controller.AddonServicesController;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(AddonServicesController.class, args);
	}
}
