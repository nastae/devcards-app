package com.devcards.devcards_service.mapper;

import com.devcards.devcards_service.dto.FeedbackRequest;
import com.devcards.devcards_service.dto.FeedbackResponse;
import com.devcards.devcards_service.entity.Feedback;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FeedbackMapper {

    Feedback toEntity(FeedbackRequest request);

    FeedbackResponse toResponse(Feedback entity);
}
