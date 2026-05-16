package com.devcards.devcards_service.mapper;

import com.devcards.devcards_service.dto.FlashcardResponse;
import com.devcards.devcards_service.entity.Flashcard;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FlashcardMapper {

    FlashcardResponse toResponse(Flashcard entity);
}
