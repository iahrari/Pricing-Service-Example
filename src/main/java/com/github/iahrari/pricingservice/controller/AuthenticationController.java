package com.github.iahrari.pricingservice.controller;

import javax.validation.Valid;

import com.github.iahrari.pricingservice.dto.AuthResponse;
import com.github.iahrari.pricingservice.dto.AuthenticationUserDTO;
import com.github.iahrari.pricingservice.service.AuthenticationService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/authentication")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @ApiResponse(
        code = 200, 
        message = "Successfully authorized"
    )
    @PostMapping
    public ResponseEntity<AuthResponse> authenticate(@RequestBody @Valid AuthenticationUserDTO user) {
        var token = authenticationService.authenticate(user);
        return ResponseEntity.ok().body(token);
    }
}
