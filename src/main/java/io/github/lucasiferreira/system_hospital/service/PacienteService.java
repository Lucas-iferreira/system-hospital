package io.github.lucasiferreira.system_hospital.service;

import io.github.lucasiferreira.system_hospital.model.Paciente;
import io.github.lucasiferreira.system_hospital.repository.PacienteRepository;
import io.github.lucasiferreira.system_hospital.utils.SenhaAtendimentoUtils;
import io.github.lucasiferreira.system_hospital.utils.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PacienteService {

    private final PacienteRepository repository;
    private final Validator validator;

    @Transactional
    public Paciente save(Paciente paciente) {
        validator.validator(paciente);

        Optional<Paciente> ultimoPacienteDoTipo = repository.findTopByEspecialidadeOrderByGeradaEmDesc(paciente.getEspecialidade());
        String ultimaSenhaAtendimento = ultimoPacienteDoTipo.map(Paciente::getSenha).orElse(null);

        String novaSenhaAtendimento = SenhaAtendimentoUtils.gerarProximaSenha(ultimaSenhaAtendimento,paciente.getEspecialidade());

        paciente.setSenha(novaSenhaAtendimento);
        paciente.setGeradaEm(LocalDateTime.now());
        return repository.save(paciente);
    }
}
