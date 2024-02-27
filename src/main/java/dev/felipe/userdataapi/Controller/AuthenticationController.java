package dev.felipe.userdataapi.Controller;

import dev.felipe.userdataapi.Request.AuthenticationRequest;
import dev.felipe.userdataapi.Request.ChangePasswordRequest;
import dev.felipe.userdataapi.Request.SignUpRequest;
import dev.felipe.userdataapi.Domain.User;
import dev.felipe.userdataapi.Response.LoginResponse;
import dev.felipe.userdataapi.Service.AuthenticationService;
import dev.felipe.userdataapi.Service.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api/auth")

public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private  AuthenticationService authService;
    @Autowired
    private TokenService tokenService;



    @PostMapping("/signup")
    public ResponseEntity<Map<String, String>> registerUser(@RequestBody @Valid SignUpRequest request) {
        return ResponseEntity.ok(authService.registerUser(request));
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String,String>> login(@RequestBody @Valid AuthenticationRequest request) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword());
        var auth = authenticationManager.authenticate(usernamePassword);
        System.out.println("Authentication details: " + auth);
        User authenticatedUser = (User) auth.getPrincipal();
        var token = tokenService.generateToken(authenticatedUser);
        return ResponseEntity.ok(Map.of("status","Login Successfull token: " + new LoginResponse(token)));

    }

    @PutMapping("/changePassword")
    public ResponseEntity<Map<String, String>> changePassword(@RequestBody @Valid ChangePasswordRequest request) {
        return ResponseEntity.ok(authService.changePassword(request));
    }

}
