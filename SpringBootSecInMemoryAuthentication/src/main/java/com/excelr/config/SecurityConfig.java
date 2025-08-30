package com.excelr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpsecurity) throws Exception {
	    httpsecurity.csrf().disable()
	        .authorizeHttpRequests()
	            .requestMatchers("/home", "/contact").permitAll()
	            .anyRequest().authenticated()
	        .and()
	        .formLogin()
	        .and()
	        .sessionManagement()
	            .sessionFixation().newSession(); // 💡 Force new session on login

	    return httpsecurity.build();
	}


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails trainer = User
            .withUsername("Ashok")
            .password(passwordEncoder().encode("ashok123"))
            .roles("JavaTrainer")
            .build();

        UserDetails student = User
            .withUsername("Bhavi")
            .password(passwordEncoder().encode("Bhavi123"))
            .roles("JavaStudent")
            .build();

        return new InMemoryUserDetailsManager(trainer, student);
    }

}
