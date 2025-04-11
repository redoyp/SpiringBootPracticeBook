package com.example.books.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.context.annotation.Bean;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig {
    @Bean
    public WebSecurityCustomizer configure() {      // 스프링 시큐리티 기능 비활성화
        return web -> web.ignoring().requestMatchers("/static/**", "/books/**", "/api/external"); // 개발하면서 잠깐 끄고 싶으면 and 뒤에 이런 식으로 붙이면 됨
    }
}
