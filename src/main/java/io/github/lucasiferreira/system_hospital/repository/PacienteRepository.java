package io.github.lucasiferreira.system_hospital.repository;

import io.github.lucasiferreira.system_hospital.model.Especialidade;
import io.github.lucasiferreira.system_hospital.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PacienteRepository extends JpaRepository<Paciente, UUID> {
    Optional<Paciente> findByCpf(String cpf);

    Optional<Paciente> findTopByEspecialidadeOrderByGeradaEmDesc(Especialidade especialidade);
}
