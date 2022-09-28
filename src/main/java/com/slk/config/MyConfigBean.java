package com.slk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.ArrayList;
import java.util.List;

/*
* 配置方式更改，舍弃
* */
@Configuration
public class MyConfigBean {
    private static final String basePath = "http://localhost:9528";


    @Bean
    public CorsFilter getCorsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        // 允许访问客户端域名
        List<String> allowedOriginPatterns = new ArrayList<>();
        allowedOriginPatterns.add(basePath);
        config.setAllowedOriginPatterns(allowedOriginPatterns);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        return new CorsFilter(source);
    }
}
