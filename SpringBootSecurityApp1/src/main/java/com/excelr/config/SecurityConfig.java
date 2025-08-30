package com.excelr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpsecurity) throws Exception {
        httpsecurity.csrf().disable()
            .authorizeHttpRequests()
                .requestMatchers("/home").permitAll()    //authentication
                .requestMatchers("/contact").permitAll() //authentication
                .anyRequest().authenticated()            //authorization
            .and()
            .formLogin(); // uses default login page

        return httpsecurity.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance(); // Use plain text
    }

}
