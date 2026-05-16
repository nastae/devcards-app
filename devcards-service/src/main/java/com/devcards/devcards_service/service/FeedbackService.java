package com.devcards.devcards_service.service;

import com.devcards.devcards_service.dto.FeedbackRequest;
import com.devcards.devcards_service.dto.FeedbackResponse;
import com.devcards.devcards_service.entity.Feedback;
import com.devcards.devcards_service.mapper.FeedbackMapper;
import com.devcards.devcards_service.repository.FeedbackRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class FeedbackService {

    private final FeedbackRepository feedbackRepository;
    private final FeedbackMapper feedbackMapper;

    public FeedbackResponse create(FeedbackRequest request) {
        Feedback entity = feedbackMapper.toEntity(request);
        entity.setCreatedAt(LocalDateTime.now());
        Feedback saved = feedbackRepository.save(entity);
        return feedbackMapper.toResponse(saved);
    }
}
