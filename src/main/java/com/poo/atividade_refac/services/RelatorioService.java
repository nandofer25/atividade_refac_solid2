package com.poo.atividade_refac.services;

import com.poo.atividade_refac.contracts.RelatorioOperations;
import com.poo.atividade_refac.repositories.LivroRepository;
import org.springframework.stereotype.Service;

@Service
public class RelatorioService implements RelatorioOperations {
    private final LivroRepository livroRepository;

    public RelatorioService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    @Override
    public void gerarRelatorio() {
        long quantidade = livroRepository.count();
        System.out.println("Quantidade de livros: " + quantidade);
    }

    @Override
    public void exportarPdf() {
        throw new UnsupportedOperationException(
                "Exportação PDF ainda não implementada");
    }
}
