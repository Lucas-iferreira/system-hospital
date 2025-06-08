package io.github.lucasiferreira.system_hospital.utils;

import io.github.lucasiferreira.system_hospital.exceptions.RegistroDuplicadoException;
import io.github.lucasiferreira.system_hospital.model.Paciente;
import io.github.lucasiferreira.system_hospital.repository.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class Validator {
    private final PacienteRepository repository;

    public void validator(Paciente paciente) {
        if (existePacienteCadastrado(paciente)) {
            throw new RegistroDuplicadoException("Paciente já cadastrado!");
        }
        paciente.setSenha(paciente.getSenha() + 1);
    }

    private boolean existePacienteCadastrado(Paciente paciente) {
        Optional<Paciente> pacienteEncontrado = repository.findByCpf(paciente.getCpf());
        if (paciente.getId() == null) {
            return pacienteEncontrado.isPresent();
        } else {
            if (pacienteEncontrado.isPresent()) {
                return !paciente.getCpf().equals(pacienteEncontrado.get().getCpf());
            }
            return false;
        }
    }

}
