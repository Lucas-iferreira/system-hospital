package io.github.lucasiferreira.system_hospital.exceptions;

public record ErroCampo(
        String campo, String erro
) {
}
