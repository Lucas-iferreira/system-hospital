package io.github.lucasiferreira.system_hospital.repository;

import io.github.lucasiferreira.system_hospital.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PacienteRepository extends JpaRepository<Paciente, UUID> {
}
