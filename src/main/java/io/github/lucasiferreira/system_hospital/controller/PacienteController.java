package io.github.lucasiferreira.system_hospital.controller;

import io.github.lucasiferreira.system_hospital.model.Paciente;
import io.github.lucasiferreira.system_hospital.model.dto.CadastrarPacienteDTO;
import io.github.lucasiferreira.system_hospital.service.PacienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pacientes")
@RequiredArgsConstructor
public class PacienteController {
    private final PacienteService service;

    @PostMapping
    public Object salvar(@RequestBody CadastrarPacienteDTO dto) {
        Paciente paciente = dto.mapearParaPaciente();
        service.save(paciente);

        return paciente;
    }
}
