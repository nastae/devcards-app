package com.devcards.devcards_service.repository;

import com.devcards.devcards_service.entity.Flashcard;
import com.devcards.devcards_service.entity.enums.StudyDay;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlashcardRepository extends JpaRepository<Flashcard, Long> {

    List<Flashcard> findTop5ByStudyDayAndDeletedFalse(StudyDay studyDay);
}
