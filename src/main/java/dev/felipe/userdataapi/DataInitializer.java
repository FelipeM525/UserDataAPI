package dev.felipe.userdataapi;

import dev.felipe.userdataapi.Domain.User;
import dev.felipe.userdataapi.Domain.UserRole;
import dev.felipe.userdataapi.Repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        initializeUsers();
    }

    @Transactional
    public void initializeUsers() {
        if (userRepository.findUserByEmailIgnoreCase("admin@admin.com").isEmpty()) {
            User adminUser = new User("admin", "admin@admin.com", passwordEncoder.encode("password123"), UserRole.ADMIN);
            userRepository.save(adminUser);
        }
    }
}
