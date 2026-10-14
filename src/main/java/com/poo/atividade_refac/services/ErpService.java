package com.poo.atividade_refac.services;

import com.poo.atividade_refac.contracts.ErpOperations;
import org.springframework.stereotype.Service;

@Service
public class ErpService implements ErpOperations {
    @Override
    public void sincronizarComERP() {
        throw new UnsupportedOperationException(
                "Integração com ERP ainda não implementada");
    }
}
