package com.github.iahrari.pricingservice.service;

import com.github.iahrari.pricingservice.dto.AuthResponse;
import com.github.iahrari.pricingservice.dto.AuthenticationUserDTO;


public interface AuthenticationService {
    AuthResponse authenticate(AuthenticationUserDTO userDTO);
}
