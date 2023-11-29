package dev.felipe.userdataapi.service;

import dev.felipe.userdataapi.Exception.CustomException;
import dev.felipe.userdataapi.domain.User;
import dev.felipe.userdataapi.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AdministratorService {
    private final UserRepository userRepository;

    public AdministratorService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Map<String, String> deleteUser(String email) {
        checkIfUserExists(email);
        userRepository.delete(userRepository.findUserByEmailIgnoreCase(email).get());
        return Map.of("status","user "+ email + " was deleted successfully");
    }
    private void checkIfUserExists(String email) {
        if(userRepository.findUserByEmailIgnoreCase(email).isEmpty()) {
            throw new CustomException(HttpStatus.BAD_REQUEST,"Bad Request!","User does not Exist!");
        }
    }
}
