package dev.felipe.userdataapi.Request;

import dev.felipe.userdataapi.Domain.UserRole;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class UpdateUserRoleRequest {
    @NotEmpty
    private String username;
    @NotNull
    private UserRole role;

    public String getUsername() {
        return username;
    }

    public UserRole getRole() {
        return role;
    }
}
