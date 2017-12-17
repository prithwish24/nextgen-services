package com.cts.product.gateway.config;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

public class FallbackProvider implements ZuulFallbackProvider{

	private FallbackResponse response;
	
	public FallbackProvider(String serviceId) {
		this.response = new FallbackResponse(serviceId);
	}
	
	public FallbackProvider(String serviceId, String code, String message) {
		this.response = new FallbackResponse(code, serviceId, message);
	}
	
	
	@Override
    public String getRoute() {
        // Might be confusing: it's the serviceId property and not the route
        return this.response.getServiceId();
    }

    @Override
    public ClientHttpResponse fallbackResponse() {
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return HttpStatus.OK.value();
            }

            @Override
            public String getStatusText() throws IOException {
                return HttpStatus.OK.toString();
            }

            @Override
            public void close() {}

            @Override
            public InputStream getBody() throws IOException {
            	return new ByteArrayInputStream(new ObjectMapper().writeValueAsBytes(response));
                //return new ByteArrayInputStream("{\"factorA\":\"Sorry, Service is Down!\",\"factorB\":\"?\",\"id\":null}".getBytes());
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                return headers;
            }
        };
    }
	
	
	
}
