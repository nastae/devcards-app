package com.devcards.devcards_service.service;

import com.devcards.devcards_service.dto.FlashcardResponse;
import com.devcards.devcards_service.entity.enums.StudyDay;
import com.devcards.devcards_service.mapper.FlashcardMapper;
import com.devcards.devcards_service.repository.FlashcardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudyService {

    private final FlashcardRepository flashcardRepository;
    private final FlashcardMapper flashcardMapper;

    public List<FlashcardResponse> getTodayFlashcards() {
//        DayOfWeek today = LocalDate.now().getDayOfWeek();
        int dayNumber = LocalDate.now().getDayOfWeek().getValue();

//        StudyDay studyDay = StudyDay.valueOf(today.name());
        StudyDay studyDay = (dayNumber % 2 == 0)
                ? StudyDay.MONDAY
                : StudyDay.TUESDAY;

        return flashcardRepository.findTop5ByStudyDayAndDeletedFalse(studyDay)
                .stream()
                .map(flashcardMapper::toResponse)
                .toList();
    }
}
