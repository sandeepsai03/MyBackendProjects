package com.excelr.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.excelr.entity.Customer;
import com.excelr.service.CustomerService;

@RestController
public class CustomerRestController {

    @Autowired
    private CustomerService cs;

    @Autowired
    private AuthenticationManager am;

    @PostMapping("/register")
    public ResponseEntity<String> registerCustomer(@RequestBody Customer c) {
        // Encrypt the password here
        boolean status = cs.saveCustomer(c, c.getPwd()); // Pass password and handle encoding inside service
        if (status) {
            return new ResponseEntity<>("Customer registered successfully", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Failed to register customer", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/login")
    public ResponseEntity<String> login(@RequestBody Customer c) {
        try {
            // Create an authentication token using the provided credentials
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(c.getEmail(), c.getPwd());

            // Attempt to authenticate the user
            Authentication authentication = am.authenticate(token);

            // If authentication is successful, set the authentication in the security context
            if (authentication.isAuthenticated()) {
                SecurityContextHolder.getContext().setAuthentication(authentication);
                return new ResponseEntity<>("Welcome, credentials are correct.", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Authentication failed", HttpStatus.UNAUTHORIZED);
            }
        } catch (Exception e) {
            // If authentication fails, return a detailed message with an error code
            return new ResponseEntity<>("Invalid credentials, please try again.", HttpStatus.BAD_REQUEST);
        }
    }
}
