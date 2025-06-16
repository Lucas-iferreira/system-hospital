package io.github.lucasiferreira.system_hospital.model.dto;

import io.github.lucasiferreira.system_hospital.model.Especialidade;
import io.github.lucasiferreira.system_hospital.model.Paciente;

public record PacienteDTO(
        String senha,
        String nome,
        Especialidade especialidade
) {}
