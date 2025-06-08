package io.github.lucasiferreira.system_hospital.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private int senha;
    private String nome;
    private String cpf;
    private String telefone;

    @Enumerated(EnumType.STRING)
    @Column(name = "tb_especialista", nullable = false)
    private Especialidade especialista;
    @Enumerated(EnumType.STRING)
    @Column(name = "tb_doc", nullable = false)
    private Doc doc;
}
