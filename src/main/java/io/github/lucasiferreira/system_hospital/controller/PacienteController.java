package io.github.lucasiferreira.system_hospital.controller;

import io.github.lucasiferreira.system_hospital.exceptions.ErroResposta;
import io.github.lucasiferreira.system_hospital.exceptions.RegistroDuplicadoException;
import io.github.lucasiferreira.system_hospital.exceptions.ResourceExceptionHandler;
import io.github.lucasiferreira.system_hospital.model.Paciente;
import io.github.lucasiferreira.system_hospital.model.dto.CadastrarPacienteDTO;
import io.github.lucasiferreira.system_hospital.model.dto.PacienteDTO;
import io.github.lucasiferreira.system_hospital.service.PacienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("pacientes")
@RequiredArgsConstructor
public class PacienteController implements GenericController {
    private final PacienteService service;

    @PostMapping
    public ResponseEntity<Object> salvar(@RequestBody @Valid CadastrarPacienteDTO dto) {
        try {
            Paciente paciente = dto.mapearParaPaciente();
            service.save(paciente);
            URI location = gerarHeaderLocation(paciente.getId());
            return ResponseEntity.created(location).build();
        } catch (RegistroDuplicadoException e) {
            ErroResposta erroDTO = ErroResposta.conflito(e.getMessage());
            return ResponseEntity.status(erroDTO.status()).body(erroDTO);
        }
    }


    @GetMapping("{id}")
    public ResponseEntity<PacienteDTO> findById(@PathVariable("id") String id) {
        var paciente = UUID.fromString(id);
        Optional<Paciente> pacienteOptional = service.findById(paciente);
        if (pacienteOptional.isPresent()) {
            Paciente pacienteEncontrado = pacienteOptional.get();

            PacienteDTO dto = new PacienteDTO(
                    pacienteEncontrado.getSenha(),
                    pacienteEncontrado.getNome(),
                    pacienteEncontrado.getEspecialidade());

            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/chamar")
    public ResponseEntity<PacienteDTO> chamarProximoPaciente() {
        Paciente proximo = service.chamarProximo();

        if (proximo == null) {
            return ResponseEntity.noContent().build(); // 204 se a fila estiver vazia
        }

        PacienteDTO dto = new PacienteDTO(
                proximo.getSenha(),
                proximo.getNome(),
                proximo.getEspecialidade()
        );

        return ResponseEntity.ok(dto);
    }

}
