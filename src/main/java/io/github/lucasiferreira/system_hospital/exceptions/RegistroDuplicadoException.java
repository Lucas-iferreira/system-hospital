package io.github.lucasiferreira.system_hospital.exceptions;

public class RegistroDuplicadoException extends RuntimeException {
    public RegistroDuplicadoException(Object cpf) {
        super("O usuário de CPF:" + cpf + " já existe!");
    }
}
