package io.github.lucasiferreira.system_hospital.model.dto;

import io.github.lucasiferreira.system_hospital.model.Doc;
import io.github.lucasiferreira.system_hospital.model.Especialidade;
import io.github.lucasiferreira.system_hospital.model.Paciente;

public record CadastrarPacienteDTO(
        String nome,
        String cpf,
        String telefone,
        Especialidade especialidade,
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
