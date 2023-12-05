package dev.felipe.userdataapi.service;

import dev.felipe.userdataapi.Exception.CustomException;
import dev.felipe.userdataapi.Request.UpdateUserRoleRequest;
import dev.felipe.userdataapi.domain.User;
import dev.felipe.userdataapi.repository.UserRepository;
import jakarta.transaction.Transactional;
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
    @Transactional
    public Map<String, String> updateUserRole(UpdateUserRoleRequest request) {
        checkIfUserExists(request.getUsername());
        User user = userRepository.findUserByUsername(request.getUsername()).get();
        user.setRole(request.getRole());
        userRepository.save(user);
        return Map.of("status","Role updated successfuly");
    }

    public Map<String, String> deleteUser(String username) {
        checkIfUserExists(username);
        userRepository.delete(userRepository.findUserByUsername(username).get());
        return Map.of("status","user "+ username + " was deleted successfully");
    }
    private void checkIfUserExists(String username) {
        if(userRepository.findUserByUsername(username).isEmpty()) {
            throw new CustomException(HttpStatus.BAD_REQUEST,"Bad Request!","User does not Exist!");
        }
    }
}
