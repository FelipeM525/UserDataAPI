package dev.felipe.userdataapi.Request;

import jakarta.validation.constraints.NotEmpty;

public class SignUpRequest {
    @NotEmpty
    private String email;
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
