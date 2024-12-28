package com.hms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.AuthorizationFilter;

@Configuration
public class SecurityConfig {

    private JWTFilter jwtFilter;

    public SecurityConfig(JWTFilter jwtFilter) {
        this.jwtFilter = jwtFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        //h(cd)2
        http.csrf().disable().cors().disable();

        //haap
        http.addFilterBefore(jwtFilter, AuthorizationFilter.class);
        http.authorizeHttpRequests().anyRequest().permitAll();

        return http.build();


    }
}
