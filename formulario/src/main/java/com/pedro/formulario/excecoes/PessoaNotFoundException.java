package com.pedro.formulario.excecoes;

public class PessoaNotFoundException extends RuntimeException  {
    public PessoaNotFoundException(Long id) {
        super("Pessoa não encontrada com o ID: " + id);
    }
}