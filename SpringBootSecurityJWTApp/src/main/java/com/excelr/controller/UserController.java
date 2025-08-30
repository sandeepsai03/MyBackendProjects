package com.excelr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.excelr.entity.AuthRequest;
import com.excelr.entity.UserInfo;
import com.excelr.service.JwtService;
import com.excelr.service.UserInfoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/auth")
@Tag(name = "Authentication API", description = "APIs for user authentication and management")
public class UserController {

    private UserInfoService userInfoService;

    @Autowired
    public void setUserInfoService(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    @Autowired
    private AuthenticationManager authenticationManager;

    private JwtService jwtService;

    @Autowired
    public void setJwtService(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @GetMapping("/welcome")
    @Operation(summary = "Welcome message", description = "Returns a welcome message")
    @ApiResponse(responseCode = "200", description = "Welcome message returned successfully")
    public String welcomeMsg() {
        return "Welcome to JWT Authentication!";
    }

    @PostMapping("/addUser")
    @Operation(summary = "Add a new user", description = "Register a new user in the system")
    @ApiResponse(responseCode = "200", description = "User registered successfully")
    @ApiResponse(responseCode = "400", description = "Invalid user data")
    public String addUser(@RequestBody UserInfo userInfo) {
        return userInfoService.addUser(userInfo);
    }

    @PostMapping("/login")
    @Operation(summary = "User login", description = "Authenticate user and return JWT token")
    @ApiResponse(responseCode = "200", description = "Login successful, JWT token returned")
    @ApiResponse(responseCode = "401", description = "Invalid credentials")
    public ResponseEntity<?> loginUser(@RequestBody AuthRequest authRequest) {
        try {
            // This will throw BadCredentialsException if authentication fails
            Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
            );
            
            // If we reach here, authentication was successful
            String token = jwtService.generateToken(authRequest.getUsername());
            return ResponseEntity.ok(token);
            
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body("Invalid username or password");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body("Authentication failed: " + e.getMessage());
        }
    }

    @GetMapping("/getUsers")
    @Operation(summary = "Get all users", description = "Retrieve a list of all registered users")
    @ApiResponse(responseCode = "200", description = "Users retrieved successfully")
    @ApiResponse(responseCode = "401", description = "Unauthorized - Invalid or missing JWT token")
    @SecurityRequirement(name = "bearerAuth")
    public List<UserInfo> getAllUsers() {
        return userInfoService.getAllUser();
    }

    @GetMapping("/getUsers/{id}")
    @Operation(summary = "Get user by ID", description = "Retrieve a specific user by their ID")
    @ApiResponse(responseCode = "200", description = "User found and returned")
    @ApiResponse(responseCode = "404", description = "User not found")
    @ApiResponse(responseCode = "401", description = "Unauthorized - Invalid or missing JWT token")
    @SecurityRequirement(name = "bearerAuth")
    public UserInfo getUserById(@PathVariable Integer id) {
        return userInfoService.getUser(id);
    }
    
    @PostMapping("/refresh")
    @Operation(summary = "Refresh JWT token", description = "Get a new JWT token using a valid token")
    @ApiResponse(responseCode = "200", description = "New token generated")
    @ApiResponse(responseCode = "401", description = "Invalid or expired token")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<?> refreshToken(HttpServletRequest request) {
        String authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            String token = authorizationHeader.substring(7);
            try {
                String username = jwtService.extractUserName(token);
                String newToken = jwtService.generateToken(username);
                return ResponseEntity.ok(newToken);
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Invalid or expired token: " + e.getMessage());
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
            .body("Authorization header is missing or invalid");
    }
}