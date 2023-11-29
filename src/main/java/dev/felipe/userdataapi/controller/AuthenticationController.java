package dev.felipe.userdataapi.controller;

import dev.felipe.userdataapi.Request.ChangePasswordRequest;
import dev.felipe.userdataapi.domain.User;
import dev.felipe.userdataapi.service.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")

public class AuthenticationController {
    private final AuthenticationService authService;

    public AuthenticationController(AuthenticationService authService) {
        this.authService = authService;
    }

    @PostMapping(path = "/signup")
    public ResponseEntity<Map<String,String>> registerUser(@RequestBody User user) {
        return ResponseEntity.ok(authService.registerUser(user));
    }
    @PutMapping(path = "/changePassword")
    public ResponseEntity<Map<String,String>> changePassword(@RequestBody ChangePasswordRequest request) {
        return ResponseEntity.ok(authService.changePassword(request));
    }

}
