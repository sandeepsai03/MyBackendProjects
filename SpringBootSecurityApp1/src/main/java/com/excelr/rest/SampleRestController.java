package com.excelr.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleRestController {

    @GetMapping("/contact")
    public ResponseEntity<String> contactMsg() {
        String s1 = "Welcome to contact page... no problem, no complication.";
        return new ResponseEntity<>(s1, HttpStatus.OK);
    }

    @GetMapping("/home")
    public ResponseEntity<String> homeMsg() {
        String s1 = "Welcome to home page... no problem, no complication.";
        return new ResponseEntity<>(s1, HttpStatus.OK);
    }

    @GetMapping("/balance")  //authorization to this method
    public ResponseEntity<String> balanceMsg() {
        String s1 = "Welcome to balance page... your balance is 50,000. Keep it safe.";
        return new ResponseEntity<>(s1, HttpStatus.OK);
    }
}
