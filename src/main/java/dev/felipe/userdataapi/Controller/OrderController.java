package dev.felipe.userdataapi.Controller;

import dev.felipe.userdataapi.Domain.Order;
import dev.felipe.userdataapi.Request.OrderRequest;
import dev.felipe.userdataapi.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController("/api/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @GetMapping("/getOrder")
    public ResponseEntity<List<Order>> getOrders(String username) {
        return orderService.getOrder(username);
    }
    @PostMapping("/createOrder")
    public ResponseEntity<Map<String,String>> createOrder(OrderRequest orderRequest) {
        return orderService.createOrder(orderRequest);
    }
}
