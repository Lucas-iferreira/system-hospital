package io.github.lucasiferreira.system_hospital.model;

public enum Especialidade {
    PEDIATRA("P"),
    ORTOPEDISTA("O"),
    OTORRINO("T"),
    PSICOLOGO("P"),
    DENTISTA("D");

    private final String prefixoSenha;

    Especialidade(String prefixoSenha) {
        this.prefixoSenha = prefixoSenha;
    }

    public String getPrefixoSenha() {
        return prefixoSenha;
    }
}
