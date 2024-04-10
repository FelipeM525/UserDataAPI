package dev.felipe.userdataapi.Repository;

import dev.felipe.userdataapi.Domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Optional<List<Order>> findOrderByOwner(String owner);
}
