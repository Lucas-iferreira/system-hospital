package io.github.lucasiferreira.system_hospital.exceptions;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record StandardError(
        LocalDateTime timestamp,
        Integer status,
        String error,
        String path
) {
}
