package io.github.lucasiferreira.system_hospital.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "senha_atendimento_exibida")
    private String senha;

    private String nome;
    private String cpf;
    private String telefone;

    @Enumerated(EnumType.STRING)
    @Column(name = "tb_especialidade", nullable = false)
    private Especialidade especialidade;
    @Enumerated(EnumType.STRING)
    @Column(name = "tb_doc", nullable = false)
    private Doc doc;
    @Column(name = "gerada_em", nullable = false)
    private LocalDateTime geradaEm;
}
