package com.devcards.devcards_service.repository;

import com.devcards.devcards_service.entity.Flashcard;
import com.devcards.devcards_service.entity.enums.StudyDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FlashcardRepository extends JpaRepository<Flashcard, Long> {

    @Deprecated
    List<Flashcard> findTop5ByStudyDayAndDeletedFalse(StudyDay studyDay);

//    TODO: fix on very large tables (100k-millions of rows)
//      1. Random ID / Offset method (simple + fast)
//        @Query(value = """
//            SELECT *
//            FROM flashcards
//            WHERE id >= :randomId
//              AND study_day = :studyDay
//              AND deleted = false
//            ORDER BY id
//            LIMIT 5
//        """, nativeQuery = true)
//        List<Flashcard> findRandomFromId(@Param("studyDay") String studyDay,
//                                         @Param("randomId") Long randomId);
//            long maxId` = flashcardRepository.findMaxId();
//
//                long randomId = ThreadLocalRandom.current().nextLong(1, maxId + 1);
//
//            return flashcardRepository.findRandomFromId(studyDay.name(), randomId)
//                        .stream()
//                    .map(flashcardMapper::toResponse)
//                    .toList();`
//    2. Indexed random column (BEST BALANCE) (scales well, used in real systems)
//      Add a column:
//        ALTER TABLE flashcards ADD COLUMN random_key DOUBLE PRECISION;
//        Fill it once:
//            UPDATE flashcards SET random_key = RANDOM();
//            Query:
//            SELECT *
//            FROM flashcards
//            WHERE study_day = ?
//            AND deleted = false
//            AND random_key > RANDOM()
//            ORDER BY random_key
//            LIMIT 5;
//        3. TABLESAMPLE (PostgreSQL only, very fast)
//            SELECT *
//            FROM flashcards TABLESAMPLE SYSTEM (1)
//            WHERE study_day = 'MONDAY'
//            LIMIT 5;
    @Query(value = """
            SELECT *
            FROM flashcards
            WHERE study_day = :studyDay
                AND deleted = false
            ORDER BY RANDOM()
            LIMIT 5
    """, nativeQuery = true)
    List<Flashcard> findRandom5ByStudyDay(@Param("studyDay") String studyDay);
}
