--liquibase formatted sql

--changeset aurimas.golotylecas:001
CREATE TABLE flashcards (
    id BIGSERIAL    PRIMARY KEY,
    front_text      VARCHAR(255) NOT NULL,
    back_text       VARCHAR(255),
    image_url       VARCHAR(255),
    study_day       VARCHAR(20) NOT NULL,
    deleted         BOOLEAN NOT NULL DEFAULT FALSE
);