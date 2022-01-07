package com.github.iahrari.pricingservice.service;

import com.github.iahrari.pricingservice.config.jwt.JwtTokenUtil;
import com.github.iahrari.pricingservice.dto.AuthResponse;
import com.github.iahrari.pricingservice.dto.AuthenticationUserDTO;
import com.github.iahrari.pricingservice.exception.UserAuthenticationException;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;

    @Override
    public AuthResponse authenticate(AuthenticationUserDTO userDTO) {
        try {
            Authentication authenticate = authenticationManager
                .authenticate(
                    new UsernamePasswordAuthenticationToken(
                        userDTO.getUsername(), userDTO.getPassword()
                    )
                );

            var user = (User) authenticate.getPrincipal();
            return AuthResponse.builder()
                    .token(jwtTokenUtil.generateAccessToken(user))
                    .build();
        } catch (BadCredentialsException ex) {
            throw new UserAuthenticationException("Bad credentials");
        }
    }
}

