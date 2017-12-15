package com.cts.product.profile.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class ConfigController {

	@Value("${msg:Default Hallo World}")
	private String msg;
	
	@RequestMapping("/msg")
	public String getMsg() {
		return msg;
	}
	
}
