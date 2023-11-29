package dev.felipe.userdataapi.service;

import dev.felipe.userdataapi.Exception.CustomException;
import dev.felipe.userdataapi.Request.ChangePasswordRequest;
import dev.felipe.userdataapi.domain.User;
import dev.felipe.userdataapi.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AuthenticationService {
    private final UserRepository userRepository;

    public AuthenticationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public Map<String, String> registerUser(User user) {
        checkIfEmailExists(user);
        userRepository.save(user);
        return Map.of("message", "User Created Successfully");
    }

    private void checkIfEmailExists(User user) {
        if (userRepository.findUserByEmailIgnoreCase(user.getEmail()).isPresent()) {
            throw new CustomException(HttpStatus.BAD_REQUEST, "Bad request!", "There is already an user with the selected email");
        }
    }

    @Transactional
    public Map<String, String> changePassword(ChangePasswordRequest request) {
        checkIfUserExists(request.getEmail());
        User user = userRepository.findUserByEmailIgnoreCase(request.getEmail()).get();
        user.setPassword(request.getNewPassword());
        userRepository.save(user);
        return Map.of("status","Password changed Successfully!");
    }
    private void checkIfUserExists(String email) {
        if (userRepository.findUserByEmailIgnoreCase(email).isEmpty()) {
            throw new CustomException(HttpStatus.NOT_FOUND,"Not Found!","User not Found!");
        }
    }
}
