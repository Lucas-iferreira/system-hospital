package io.github.lucasiferreira.system_hospital.controller;

import io.github.lucasiferreira.system_hospital.exceptions.RegistroDuplicadoException;
import io.github.lucasiferreira.system_hospital.exceptions.ResourceExceptionHandler;
import io.github.lucasiferreira.system_hospital.model.Paciente;
import io.github.lucasiferreira.system_hospital.model.dto.CadastrarPacienteDTO;
import io.github.lucasiferreira.system_hospital.service.PacienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("pacientes")
@RequiredArgsConstructor
public class PacienteController implements GenericController{
    private final PacienteService service;

    @PostMapping
    public ResponseEntity<Object> salvar(@RequestBody CadastrarPacienteDTO dto) {
        try {

            Paciente paciente = dto.mapearParaPaciente();
            service.save(paciente);
            URI location = gerarHeaderLocation(paciente.getId());

            return ResponseEntity.created(location).build();
        } catch (RegistroDuplicadoException e) {
            throw e;
        }
    }
}
