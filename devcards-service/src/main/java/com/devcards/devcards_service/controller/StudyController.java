package com.devcards.devcards_service.controller;

import com.devcards.devcards_service.dto.FlashcardResponse;
import com.devcards.devcards_service.service.StudyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/study")
@RequiredArgsConstructor
public class StudyController {

    private final StudyService studyService;

    @GetMapping
    public ResponseEntity<List<FlashcardResponse>> getTodayStudy() {
        return ResponseEntity.ok(
                studyService.getTodayFlashcards()
        );
    }
}
