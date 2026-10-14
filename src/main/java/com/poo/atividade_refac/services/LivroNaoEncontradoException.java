package com.poo.atividade_refac.services;

public class LivroNaoEncontradoException extends RuntimeException {
    public LivroNaoEncontradoException(Long id) {
        super("Livro não encontrado: " + id);
    }
}
