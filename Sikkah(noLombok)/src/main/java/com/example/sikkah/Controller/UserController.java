package com.example.sikkah.Controller;

import com.example.sikkah.ApiResponse.ApiResponse;
import com.example.sikkah.Model.User;
import com.example.sikkah.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/get")
    public ResponseEntity getAllUsers() {
        return ResponseEntity.status(200).body(userService.getAllUsers());
    }

    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody @Valid User user, Errors errors) {
        if (errors.hasErrors())
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());

        userService.addUser(user);
        return ResponseEntity.status(200).body(new ApiResponse("User has been added successfully"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable Integer id, @RequestBody @Valid User user, Errors errors) {
        if (errors.hasErrors())
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());

        userService.updateUser(id, user);
        return ResponseEntity.status(200).body(new ApiResponse("User with ID: " + id + " has been updated successfully"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return ResponseEntity.status(200).body(new ApiResponse("User with ID: " + id + " has been updated successfully"));
    }
    // CRUD - END

    // Getters
    @GetMapping("/get/by-id/{id}")
    public ResponseEntity getUserById(@PathVariable Integer id) {
        return ResponseEntity.status(200).body(userService.getUserById(id));
    }

    @GetMapping("/get/by-email/{email}")
    public ResponseEntity getUserByEmail(@RequestBody String email) {
        return ResponseEntity.status(200).body(userService.getUserByEmail(email));
    }

    // Services
    @PutMapping("/transfer/{senderId}/{amount}")
    public ResponseEntity transferToUser(@PathVariable Integer senderId, @PathVariable Double amount, @RequestBody String email) {
        userService.transferToUser(senderId, amount, email);
        return ResponseEntity.status(200).body(new ApiResponse("Amount has been transferred successfully"));
    }

}
