package com.cts.product.config.controller;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@ComponentScan(basePackages= {"com.cts.product.config"})
public class RefreshController {
	
}
