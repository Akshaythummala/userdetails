package com.example.user_details_service.Repository;

import com.example.user_details_service.Model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill, Long> {
}
