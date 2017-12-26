package com.cts.product.addon.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

/**
 * The Spring configuration class indicating that instances of classes in this
 * module should be managed by the Spring context.
 */
@Configuration
@EnableCaching
public class CacheConfig {
}
