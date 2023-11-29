package dev.felipe.userdataapi.controller;

import dev.felipe.userdataapi.domain.User;
import dev.felipe.userdataapi.service.AdministratorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/admin")
public class AdminController {
    private final AdministratorService adminService;

    public AdminController(AdministratorService adminService) {
        this.adminService = adminService;
    }

    @GetMapping(path = "users")
    public ResponseEntity<List<User>> getAllRegisteredUserInfo(){
        return ResponseEntity.ok(adminService.getAllUsers());
    }
    @DeleteMapping
    public ResponseEntity<Map<String,String>> deleteUser(String email) {
        return ResponseEntity.ok(adminService.deleteUser(email));
    }
}
