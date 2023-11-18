package com.folkandkin.tienda.security.jwt;

import com.folkandkin.tienda.security.domain.UserDetailsImpl;
import com.folkandkin.tienda.security.service.impl.UserDetailsServiceImpl;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Clase para el filtrado del Token (JWT).
 *
 * @version v1 17 Nov 2023
 * @author Leandro Deferrari
 */

@Component
public class JwtAuthorizationFilter extends OncePerRequestFilter {
    private final JwtTokenProvider jwtTokenProvider;
    private final UserDetailsServiceImpl userDetailsServiceImpl;

    public JwtAuthorizationFilter(JwtTokenProvider jwtTokenProvider,
                                  UserDetailsServiceImpl userDetailsServiceImpl){
        this.jwtTokenProvider = jwtTokenProvider;
        this.userDetailsServiceImpl = userDetailsServiceImpl;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        final String bearerToken = request.getHeader("Authorization");

        String email = null;
        String jwtToken = null;

        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            jwtToken = bearerToken.substring(7);
            email = this.jwtTokenProvider.getUsernameFromToken(jwtToken);
        }

        if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetailsImpl userDetailsImpl = this.userDetailsServiceImpl.loadUserByUsername(email);

            if (Boolean.TRUE.equals(this.jwtTokenProvider.validateToken(jwtToken, userDetailsImpl))) {
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetailsImpl, null, userDetailsImpl.getAuthorities());
                usernamePasswordAuthenticationToken
                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }
        chain.doFilter(request, response);
    }
}
