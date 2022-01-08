package com.github.iahrari.pricingservice.dto;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationUserDTO {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
}
