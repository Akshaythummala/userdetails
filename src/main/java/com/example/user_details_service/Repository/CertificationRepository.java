package com.example.user_details_service.Repository;

import com.example.user_details_service.Model.Certification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CertificationRepository extends JpaRepository<Certification, Long> {
}
