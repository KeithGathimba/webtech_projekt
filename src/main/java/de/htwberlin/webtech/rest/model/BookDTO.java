package de.htwberlin.webtech.rest.model;

public record BookDTO(
        Long id,
        String title,
        String author,
        int releaseYear,
        String status,
        int rating // <--- NEU
) { }