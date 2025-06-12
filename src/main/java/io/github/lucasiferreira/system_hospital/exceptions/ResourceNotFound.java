package io.github.lucasiferreira.system_hospital.exceptions;

public class ResourceNotFound extends RuntimeException {
    public ResourceNotFound(Object id) {
      super("Paciente não encontrado");
    }
}
