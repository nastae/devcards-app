package com.devcards.devcards_service.dto;

import java.time.LocalDateTime;

public record FeedbackResponse(Long id, String message, LocalDateTime createdAt) {
}
