package com.excelr.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.excelr.service.CustomerService;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig {

    @Autowired
    private CustomerService cs;

    @Bean
    public BCryptPasswordEncoder pwdEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authProvider() {
        DaoAuthenticationProvider ap = new DaoAuthenticationProvider();
        ap.setPasswordEncoder(pwdEncoder());
        ap.setUserDetailsService(cs);
        return ap;
    }

    @Bean
    public AuthenticationManager authManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpsecurity) throws Exception {
        httpsecurity.authorizeHttpRequests((req) -> {
            req.requestMatchers("/register", "/login").permitAll()
            .anyRequest().authenticated();
        });
        return httpsecurity.csrf().disable().build();
    }
}
