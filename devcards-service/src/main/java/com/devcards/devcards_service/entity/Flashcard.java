package com.devcards.devcards_service.entity;

import com.devcards.devcards_service.entity.enums.StudyDay;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "flashcards")
@Getter
@Setter
public class Flashcard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "front_text", nullable = false)
    private String frontText;

    @Column(name = "back_text")
    private String backText;

    @Column(name = "image_url")
    private String imageUrl;

    @Enumerated(EnumType.STRING)
    @Column(name = "study_day", nullable = false)
    private StudyDay studyDay;

    @Column(name = "deleted", nullable = false)
    private boolean deleted = false;
}
