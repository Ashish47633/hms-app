package com.hms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.AuthorizationFilter;

@Configuration
public class SecurityConfig{

    private JWTFilter jwtFilter;

    public SecurityConfig(JWTFilter jwtFilter) {
        this.jwtFilter = jwtFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{
        //h(cd cd)
        http.csrf().disable().cors().disable();
        http.addFilterBefore(jwtFilter, AuthorizationFilter.class);

//        http.authorizeHttpRequests()
//                .requestMatchers("/api/v1/user/login", "/api/v1/user/signup", "/api/v1/user/signup-property-owner","/api/v1/user/deleteUser")
//                .permitAll()
//                .requestMatchers("/api/v1/country/addCountry").hasAnyRole("OWNER","ADMIN")
//                .anyRequest().authenticated();

        //haap
        http.authorizeHttpRequests().anyRequest().permitAll();

        return http.build();
    }

}
