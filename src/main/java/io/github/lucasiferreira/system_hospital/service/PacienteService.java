package io.github.lucasiferreira.system_hospital.service;

import io.github.lucasiferreira.system_hospital.model.Paciente;
import io.github.lucasiferreira.system_hospital.repository.PacienteRepository;
import io.github.lucasiferreira.system_hospital.utils.SenhaAtendimentoUtils;
import io.github.lucasiferreira.system_hospital.utils.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PacienteService {

    private final PacienteRepository repository;
    private final Validator validator;

    private final Queue<Paciente> fila = new LinkedList<>();

    @Transactional
    public Paciente save(Paciente paciente) {
        validator.validator(paciente);

        Optional<Paciente> ultimoPacienteDoTipo = repository.findTopByEspecialidadeOrderByGeradaEmDesc(paciente.getEspecialidade());
        String ultimaSenhaAtendimento = ultimoPacienteDoTipo.map(Paciente::getSenha).orElse(null);

        String novaSenhaAtendimento = SenhaAtendimentoUtils.gerarProximaSenha(ultimaSenhaAtendimento, paciente.getEspecialidade());

        paciente.setSenha(novaSenhaAtendimento);
        paciente.setGeradaEm(LocalDateTime.now());

        Paciente salvo = repository.save(paciente);
        fila.offer(salvo);
        return salvo;
    }

    @Transactional(readOnly = true)
    public Optional<Paciente> findById(UUID id) {
        return repository.findById(id);
    }

    public Paciente chamarProximo(){
        return fila.poll();
    }
}
