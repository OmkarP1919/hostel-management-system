package com.hostel.backend.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.lang.NonNull;

import org.springframework.security.authentication.
UsernamePasswordAuthenticationToken;

import org.springframework.security.core.context.
SecurityContextHolder;

import org.springframework.security.core.userdetails.
UserDetails;

import org.springframework.security.web.authentication.
WebAuthenticationDetailsSource;

import org.springframework.stereotype.Component;

import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter
        extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private CustomUserDetailsService
            userDetailsService;

    @Override
    protected boolean shouldNotFilter(

            HttpServletRequest request

    ) {

        String path = request.getServletPath();

        return path.startsWith("/swagger-ui")

                ||

                path.startsWith("/v3/api-docs")

                ||

                path.startsWith("/swagger-resources")

                ||

                path.startsWith("/webjars")

                ||

                path.startsWith("/api/auth");
    }

    @Override
    protected void doFilterInternal(

            @NonNull HttpServletRequest request,

            @NonNull HttpServletResponse response,

            @NonNull FilterChain filterChain

    ) throws ServletException, IOException {

        final String authHeader =
                request.getHeader("Authorization");

        String jwt = null;

        String email = null;

        if (

                authHeader != null

                        &&

                        authHeader.startsWith("Bearer ")

        ) {

            jwt = authHeader.substring(7);

            email = jwtUtil.extractEmail(jwt);
        }

        if (

                email != null

                        &&

                        SecurityContextHolder

                                .getContext()

                                .getAuthentication() == null

        ) {

            UserDetails userDetails =

                    userDetailsService

                            .loadUserByUsername(email);

            if (jwtUtil.isTokenValid(jwt)) {

                UsernamePasswordAuthenticationToken authToken =

                        new UsernamePasswordAuthenticationToken(

                                userDetails,

                                null,

                                userDetails.getAuthorities()
                        );

                authToken.setDetails(

                        new WebAuthenticationDetailsSource()

                                .buildDetails(request)
                );

                SecurityContextHolder

                        .getContext()

                        .setAuthentication(authToken);
            }
        }

        filterChain.doFilter(request, response);
    }
}