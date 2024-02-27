package dev.felipe.userdataapi.Controller;

import dev.felipe.userdataapi.Request.UpdateUserRoleRequest;
import dev.felipe.userdataapi.Domain.User;
import dev.felipe.userdataapi.Service.AdministratorService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/admin")
public class AdminController {
    private final AdministratorService adminService;

    public AdminController(AdministratorService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllRegisteredUserInfo(){
        return ResponseEntity.ok(adminService.getAllUsers());
    }
    @PutMapping("/update")
    public ResponseEntity<Map<String,String>> updateUserRole(@RequestBody @Valid UpdateUserRoleRequest request) {
        return ResponseEntity.ok(adminService.updateUserRole(request));
    }
    @DeleteMapping("/delete/{email}")
    public ResponseEntity<Map<String,String>> deleteUser(@PathVariable String email) {
        return ResponseEntity.ok(adminService.deleteUser(email));
    }
}
