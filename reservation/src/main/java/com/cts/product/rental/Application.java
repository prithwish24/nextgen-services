package com.cts.product.rental;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cts.product.rental.controller.ReservationController;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(ReservationController.class, args);
		/*new SpringApplicationBuilder(ReservationController.class)
		.bannerMode(Banner.Mode.OFF)
		.run(args);*/
	}
}
