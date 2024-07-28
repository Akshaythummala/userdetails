package com.example.user_details_service.Repository;

import com.example.user_details_service.Model.EmploymentHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmploymentHistoryRepository extends JpaRepository<EmploymentHistory, Long> {
}
