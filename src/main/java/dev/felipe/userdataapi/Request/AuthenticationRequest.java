package dev.felipe.userdataapi.Request;

import jakarta.validation.constraints.NotEmpty;

public class AuthenticationRequest {
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
