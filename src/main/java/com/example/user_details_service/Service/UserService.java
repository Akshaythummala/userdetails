package com.example.user_details_service.Service;

import com.example.user_details_service.Model.EducationalHistory;
import com.example.user_details_service.Model.EmploymentHistory;
import com.example.user_details_service.Model.User;
import com.example.user_details_service.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    public User addUser(User user) {
        try {
            return userRepository.save(user);
        } catch (Exception e) {
            logger.error("Error adding user", e);
            throw new RuntimeException("Error adding user: " + e.getMessage());
        }
    }

    public User getUserById(Long id) {
        try {
            Optional<User> user = userRepository.findById(id);
            if (user.isPresent()) {
                return user.get();
            } else {
                throw new RuntimeException("User not found with id: " + id);
            }
        } catch (Exception e) {
            logger.error("Error retrieving user", e);
            throw new RuntimeException("Error retrieving user: " + e.getMessage());
        }
    }

    public User updateUser(User user) {
        try {
            if (userRepository.existsById(user.getId())) {
                return userRepository.save(user);
            } else {
                throw new RuntimeException("User not found with id: " + user.getId());
            }
        } catch (Exception e) {
            logger.error("Error updating user", e);
            throw new RuntimeException("Error updating user: " + e.getMessage());
        }
    }

    public void deleteUser(Long id) {
        try {
            if (userRepository.existsById(id)) {
                userRepository.deleteById(id);
            } else {
                throw new RuntimeException("User not found with id: " + id);
            }
        } catch (Exception e) {
            logger.error("Error deleting user", e);
            throw new RuntimeException("Error deleting user: " + e.getMessage());
        }
    }
        public User addEmploymentHistory(Long userId, List<EmploymentHistory> employmentHistories) {
            User user = userRepository.findById(userId).orElse(null);
            if (user != null) {
                user.getEmploymentHistory().addAll(employmentHistories);
                return userRepository.save(user);
            }
            return null;
    }
    public User addEducationalHistory(Long userId, List<EducationalHistory> educationalHistories) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            user.getEducationalHistory().addAll(educationalHistories);
            return userRepository.save(user);
        }
        return null;
    }
}
