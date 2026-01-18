package de.htwberlin.webtech.rest.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record BookDTO(
        Long id,
        @NotBlank(message = "Titel darf nicht leer sein")
        String title,

        @NotBlank(message = "Autor darf nicht leer sein")
        String author,

        int releaseYear,
        String status,
        int rating
) { }