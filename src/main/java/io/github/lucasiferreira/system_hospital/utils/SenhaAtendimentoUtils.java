package io.github.lucasiferreira.system_hospital.utils;

import io.github.lucasiferreira.system_hospital.model.Especialidade;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SenhaAtendimentoUtils {

    // Padrão para extrair o prefixo e o número (ex: "A", "001")
    private static final Pattern SENHA_PADRAO = Pattern.compile("([A-Z])(\\d+)");

    public static String getPrefixoDaEspecialidade(Especialidade especialidade) {
        return especialidade.getPrefixoSenha();
    }

    public static String gerarProximaSenha(String ultimaSenhaExistente, Especialidade especialidade) {
        String prefixo = getPrefixoDaEspecialidade(especialidade);

        if (ultimaSenhaExistente == null || ultimaSenhaExistente.isEmpty()) {
            return String.format("%s%03d", prefixo, 1);
        }
        Matcher matcher = SENHA_PADRAO.matcher(ultimaSenhaExistente);
        if (matcher.matches()) {
            String prefixoEncontrado = matcher.group(1); //EX: "A"

            int numero = Integer.parseInt(matcher.group(2)); //Ex: 1(de "001")

            if (!prefixoEncontrado.equals(prefixo)) {
                System.err.println("Aviso: última senha encontrada ('" + ultimaSenhaExistente + "')" +
                        " não corresponde ao prefixo esperado ('" + prefixo + "'). Reiniciando contagem" +
                        " para este prefixo.");
                return String.format("%s%03d", prefixo, 1);
            }

            int proximoNumero = numero + 1;
            return String.format("%s%03d", prefixo, proximoNumero);
        } else {
            throw new IllegalArgumentException("Formato não disponivel");
        }
    }
}
