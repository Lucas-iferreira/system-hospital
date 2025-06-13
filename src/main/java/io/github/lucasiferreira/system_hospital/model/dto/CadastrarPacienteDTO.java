package io.github.lucasiferreira.system_hospital.model.dto;

import io.github.lucasiferreira.system_hospital.model.Doc;
import io.github.lucasiferreira.system_hospital.model.Especialidade;
import io.github.lucasiferreira.system_hospital.model.Paciente;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

public record CadastrarPacienteDTO(
        @NotNull
        String nome,
        @NotNull
        @CPF
        String cpf,
        String telefone,
        @NotNull
        Especialidade especialidade,
        @NotNull
        Doc doc
) {
    public Paciente mapearParaPaciente(){
        Paciente paciente = new Paciente();
        paciente.setNome(this.nome);
        paciente.setCpf(this.cpf);
        paciente.setTelefone(this.telefone);
        paciente.setEspecialidade(this.especialidade);
        paciente.setDoc(this.doc);
        return paciente;
    }
}
