package com.poo.atividade_refac.services;

import com.poo.atividade_refac.contracts.EtiquetaOperations;
import org.springframework.stereotype.Service;

@Service
public class EtiquetaService implements EtiquetaOperations {
    @Override
    public void gerarEtiqueta() {
        throw new UnsupportedOperationException(
                "Geração de etiqueta ainda não implementada");
    }
}
