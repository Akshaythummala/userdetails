package com.example.user_details_service.Controller;

import com.example.user_details_service.Model.EducationalHistory;
import com.example.user_details_service.Model.EmploymentHistory;
import com.example.user_details_service.Model.User;
import com.example.user_details_service.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-details")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public User addUser(@RequestBody User user) {
        try {
            return userService.addUser(user);
        } catch (Exception e) {
            throw new RuntimeException("Error adding user: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        try {
            return userService.getUserById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving user: " + e.getMessage());
        }
    }

    @PostMapping("/update")
    public User updateUser(@RequestBody User user) {
        try {
            return userService.updateUser(user);
        } catch (Exception e) {
            throw new RuntimeException("Error updating user: " + e.getMessage());
        }
    }

    @PostMapping("/delete")
    public void deleteUser(@RequestParam Long id) {
        try {
            userService.deleteUser(id);
        } catch (Exception e) {
            throw new RuntimeException("Error deleting user: " + e.getMessage());
        }
    }
        @PostMapping("/{userId}/employment-history")
        public User addEmploymentHistory(@PathVariable Long userId, @RequestBody List<EmploymentHistory> employmentHistories) {
            return userService.addEmploymentHistory(userId, employmentHistories);
        }

    @PostMapping("/{userId}/educational-history")
    public User addEducationalHistory(@PathVariable Long userId, @RequestBody List<EducationalHistory> educationalHistories) {
        return userService.addEducationalHistory(userId, educationalHistories);
    }
}