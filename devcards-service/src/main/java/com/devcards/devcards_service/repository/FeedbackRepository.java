package com.devcards.devcards_service.repository;

import com.devcards.devcards_service.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
}
