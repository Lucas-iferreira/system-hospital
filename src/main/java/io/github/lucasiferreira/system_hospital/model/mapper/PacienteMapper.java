package io.github.lucasiferreira.system_hospital.model.mapper;

import io.github.lucasiferreira.system_hospital.model.Paciente;
import io.github.lucasiferreira.system_hospital.model.dto.CadastrarPacienteDTO;
import io.github.lucasiferreira.system_hospital.model.dto.PacienteDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PacienteMapper {

    Paciente toEntity(CadastrarPacienteDTO dto);
    PacienteDTO toDTO(Paciente entity);
}
