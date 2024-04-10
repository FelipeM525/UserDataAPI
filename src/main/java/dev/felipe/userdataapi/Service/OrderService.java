package dev.felipe.userdataapi.Service;

import dev.felipe.userdataapi.Domain.Order;
import dev.felipe.userdataapi.Exception.CustomException;
import dev.felipe.userdataapi.Repository.OrderRepository;
import dev.felipe.userdataapi.Repository.ParcelRepository;
import dev.felipe.userdataapi.Repository.UserRepository;
import dev.felipe.userdataapi.Request.OrderRequest;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ParcelRepository parcelRepository;

    public ResponseEntity<List<Order>> getOrder(String username) {
        Optional<List<Order>> OptionalOrdersByOwner = orderRepository.findOrderByOwner(username);
        return OptionalOrdersByOwner.map(ResponseEntity::ok).orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND,"Not Found", "Order not found"));
    }
    @Transactional
    public ResponseEntity<Map<String,String>> createOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOwner(userRepository.findUserByUsername(orderRequest.getOwner()).orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND, "Not Found", "User not found")));
        order.setOrderDate(orderRequest.getOrderDate());
        order.setParcels(orderRequest.getParcels());
        parcelRepository.saveAll(order.getParcels());
        orderRepository.save(order);
        return ResponseEntity.ok(Map.of("Status",String.format("The Order with id %d has been created successfully", order.getId())));
    }

}
