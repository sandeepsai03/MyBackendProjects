package com.excelr.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.excelr.entity.Customer;
import com.excelr.repository.CustomerRepository;

@Service
public class CustomerService implements UserDetailsService {

    @Autowired
    private CustomerRepository cr;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Customer c = cr.findByEmail(email);
        if (c == null) {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }
        return new User(c.getEmail(), c.getPwd(), Collections.emptyList());
    }
    
    public boolean saveCustomer(Customer c, String encodedPassword) {
        c.setPwd(encodedPassword);  // Use the encoded password here
        Customer savedCustomer = cr.save(c);
        return savedCustomer.getCid() != null;
    }
}
