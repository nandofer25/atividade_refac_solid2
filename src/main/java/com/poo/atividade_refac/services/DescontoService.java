package com.poo.atividade_refac.services;

import com.poo.atividade_refac.contracts.PoliticaDesconto;
import com.poo.atividade_refac.entities.Livro;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DescontoService {
    private final List<PoliticaDesconto> politicas;

    public DescontoService(List<PoliticaDesconto> politicas) {
        this.politicas = politicas;
    }

    public void aplicarDesconto(Livro livro) {
        politicas.stream()
                .filter(politica -> politica.suporta(livro.getCategoria()))
                .findFirst()
                .ifPresent(politica -> politica.aplicar(livro));
    }
}
