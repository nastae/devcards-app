--liquibase formatted sql

--changeset aurimas.golotylecas:001
CREATE TABLE flashcards (
    id BIGSERIAL PRIMARY KEY
);