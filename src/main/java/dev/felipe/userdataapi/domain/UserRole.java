package dev.felipe.userdataapi.domain;

public enum UserRole {
    ADMIN("admin"),
    PREMIUM("premium"),
    USER("user");
    private String role;
    UserRole(String role) {
        this.role = role;
    }
    public String getRole() {
        return role;
    }
}
