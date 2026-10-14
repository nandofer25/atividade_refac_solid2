package com.poo.atividade_refac.contracts;

import com.poo.atividade_refac.entities.Livro;

/** Estratégia de desconto para uma categoria específica. */
public interface PoliticaDesconto {
    boolean suporta(String categoria);
    void aplicar(Livro livro);
}
