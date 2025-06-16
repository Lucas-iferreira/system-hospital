package io.github.lucasiferreira.system_hospital.model.mapper;

import io.github.lucasiferreira.system_hospital.model.Paciente;
import io.github.lucasiferreira.system_hospital.model.dto.CadastrarPacienteDTO;
import io.github.lucasiferreira.system_hospital.model.dto.PacienteDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PacienteMapper {

    PacienteDTO toDTO(Paciente entity);
    Paciente toEntity(PacienteDTO dto);
    Paciente toEntity(CadastrarPacienteDTO dto);
}
