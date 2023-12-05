package dev.felipe.userdataapi.Request;

import jakarta.validation.constraints.NotEmpty;

public class ChangePasswordRequest {
    @NotEmpty
    private String username;
    @NotEmpty
    private String newPassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
