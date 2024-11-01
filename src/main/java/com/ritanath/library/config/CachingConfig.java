package com.ritanath.library.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableCaching
public class CachingConfig {

    public static final String BOOKS_CACHE_NAME = "books";

    public static final String StudentS_CACHE_NAME = "Students";
}
