package com.myapp.spring_myapp_service.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
//redirecting react app to /home
private static final Logger LOGGER = LoggerFactory.getLogger(WebConfig.class);


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/home/**")
                .addResourceLocations("classpath:/static");
    }
}
