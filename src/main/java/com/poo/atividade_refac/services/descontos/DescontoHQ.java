package com.poo.atividade_refac.services.descontos;

import com.poo.atividade_refac.contracts.PoliticaDesconto;
import com.poo.atividade_refac.entities.Livro;
import org.springframework.stereotype.Component;

@Component
public class DescontoHQ implements PoliticaDesconto {
    @Override
    public boolean suporta(String categoria) {
        return "HQ".equalsIgnoreCase(categoria);
    }

    @Override
    public void aplicar(Livro livro) {
        livro.setPreco(livro.getPreco() * 0.60);
    }
}
