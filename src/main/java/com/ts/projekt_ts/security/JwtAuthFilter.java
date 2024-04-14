package com.ts.projekt_ts.security;

import com.ts.projekt_ts.infrastucture.service.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {
    /**
     * Constructs a JwtAuthFilter with the provided JwtService.
     */
    private final JwtService jwtService;
    @Autowired
    public JwtAuthFilter(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        /**
         * Performs the JWT authentication and sets up the authentication in the Spring Security context.
         * @param request     the HTTP servlet request
         * @param response    the HTTP servlet response
         * @param filterChain the filter chain to proceed with
         * @throws ServletException if a servlet exception occurs
         * @throws IOException      if an I/O exception occurs
         */
        try{
            final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
            final String jwt;
            if(authHeader == null || !authHeader.startsWith("Bearer ")){
                filterChain.doFilter(request, response);
                return;
            }
            jwt = authHeader.substring(7);
            final String role = jwtService.extractRole(jwt).name();
            final String username = jwtService.extractUsername(jwt);

            if(username !=null && !username.isEmpty() && SecurityContextHolder.getContext().getAuthentication() == null){
                if(jwtService.isTokenValid(jwt)){
                    SecurityContext securityContext = SecurityContextHolder.createEmptyContext();
                    UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username, null, List.of(new SimpleGrantedAuthority(role)));
                    authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    securityContext.setAuthentication(authToken);
                    SecurityContextHolder.setContext(securityContext);
                }
            }
        filterChain.doFilter(request, response);
        }catch (Exception e){
            filterChain.doFilter(request, response);
        }

    }
}
