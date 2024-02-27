package dev.felipe.userdataapi.Repository;

import dev.felipe.userdataapi.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findUserByEmailIgnoreCase(String email);
    Optional<User> findUserByUsername(String username);
    List<User> findAll();
}
