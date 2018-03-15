package com.cts.product.health;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController("/")
@ComponentScan(basePackages = { "com.cts.product.health" })
public class Application {
	private static final int DEFAULT_TIMEOUT = 30000;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Autowired
	private RestTemplate restTemplate; 
	
	@Bean
	public RestTemplate restTemplate() {
		HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
		factory.setReadTimeout(DEFAULT_TIMEOUT);
		factory.setConnectTimeout(DEFAULT_TIMEOUT);
	    return new RestTemplate(factory);
	}
	
	private String ping (String endpoint) {
		try {
			return restTemplate.getForObject(endpoint, String.class);
		} catch (RestClientException re) {
			throw new RuntimeException("Service is DOWN", re);
		}
	}
	
	@RequestMapping(path="/config/ping", method=RequestMethod.GET, params= {})
	public String pingConfig(@RequestParam(name="host", defaultValue="http://localhost:8199") String host) {
		return ping(host+"/health");
	}
	@RequestMapping(path="/eureka/ping", method=RequestMethod.GET)
	public String pingEureka(@RequestParam(name="host", defaultValue="http://localhost:8088") String host) {
		return ping(host+"/health");
	}
	@RequestMapping(path="/profile/ping", method=RequestMethod.GET)
	public String pingProfile(@RequestParam(name="host", defaultValue="http://localhost:8001") String host) {
		return ping(host+"/health");
	}
	@RequestMapping(path="/reservation/ping", method=RequestMethod.GET)
	public String pingReservation(@RequestParam(name="host", defaultValue="http://localhost:8002") String host) {
		return ping(host+"/health");
	}
	@RequestMapping(path="/addonsvc/ping", method=RequestMethod.GET)
	public String pingAddonSvc(@RequestParam(name="host", defaultValue="http://localhost:8003") String host) {
		return ping(host+"/health");
	}
	@RequestMapping(path="/gateway/ping", method=RequestMethod.GET)
	public String pingZuul(@RequestParam(name="host", defaultValue="http://localhost:8080") String host) {
		return ping(host+"/health");
	}
	@RequestMapping(path="/monitor/ping", method=RequestMethod.GET)
	public String pingMonitor(@RequestParam(name="host", defaultValue="http://localhost:8090") String host) {
		return ping(host+"/health");
	}
	
	
}
