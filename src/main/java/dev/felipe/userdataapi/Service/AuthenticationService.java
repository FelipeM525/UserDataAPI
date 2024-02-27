package dev.felipe.userdataapi.Service;

import dev.felipe.userdataapi.Exception.CustomException;
import dev.felipe.userdataapi.Request.ChangePasswordRequest;
import dev.felipe.userdataapi.Request.SignUpRequest;
import dev.felipe.userdataapi.Domain.User;
import dev.felipe.userdataapi.Domain.UserRole;
import dev.felipe.userdataapi.Repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AuthenticationService {
    @Autowired
   private UserRepository userRepository;
    @Autowired
   private PasswordEncoder passwordEncoder;

    @Transactional
    public Map<String, String> registerUser(SignUpRequest request) {
        User user = new User(request.getUsername(), request.getEmail(), request.getPassword(), UserRole.USER );
        checkIfUserExists(user);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        userRepository.save(user);
        return Map.of("status", "User Created Successfully");
    }

    private void checkIfUserExists(User user) {
        if (userRepository.findUserByUsername(user.getUsername()).isPresent()) {
            throw new CustomException(HttpStatus.BAD_REQUEST, "Bad request!", "User Already Exists!");
        }
    }

    @Transactional
    public Map<String, String> changePassword(ChangePasswordRequest request) {
        User user = userRepository.findUserByUsername(request.getUsername()).orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND,"Not Found!","User Not Found!"));
        user.setPassword(passwordEncoder.encode(request.getNewPassword()));
        userRepository.save(user);
        return Map.of("status","Password changed Successfully!");
    }

}
