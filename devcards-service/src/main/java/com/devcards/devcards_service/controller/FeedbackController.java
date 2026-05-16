package com.devcards.devcards_service.controller;

import com.devcards.devcards_service.dto.FeedbackRequest;
import com.devcards.devcards_service.dto.FeedbackResponse;
import com.devcards.devcards_service.service.FeedbackService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/feedback")
@RequiredArgsConstructor
public class FeedbackController {

    private final FeedbackService feedbackService;

    @PostMapping
    public ResponseEntity<FeedbackResponse> create(@RequestBody FeedbackRequest request) {
        return ResponseEntity.ok(
                feedbackService.create(request)
        );
    }
}
