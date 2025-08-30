package com.excelr.filter;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.excelr.service.JwtService;
import com.excelr.service.UserInfoService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter extends OncePerRequestFilter {

	private JwtService jwtService;

	@Autowired
	public void setJwtService(JwtService jwtService) {
	    this.jwtService = jwtService;
	}


    private UserInfoService userInfoService;

    @Autowired
    public void setUserInfoService(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    // This method runs once per request
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        // Extract the Authorization header
        String authHeader = request.getHeader("Authorization");
        String token = null;
        String userName = null;
    
 // Check if the header contains "Bearer" prefix
    if (authHeader != null && authHeader.startsWith("Bearer ")) {
        token = authHeader.substring(7); // Remove "Bearer " part
        userName = jwtService.extractUserName(token);
    }

    // If the userName is not null and there's no authentication set in the context
    if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
        // Load user details based on the userName
        UserDetails userDetails = userInfoService.loadUserByUsername(userName);

        // Validate the token
        if (jwtService.validateToken(token, userName)) {
            // If the token is valid, create an authentication token
            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails,
                    null, userDetails.getAuthorities());
            authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

            // Set the authentication token in the security context
            SecurityContextHolder.getContext().setAuthentication(authToken);
        }
    }

    // Continue the filter chain to allow the request to proceed
    filterChain.doFilter(request, response);

}
}

