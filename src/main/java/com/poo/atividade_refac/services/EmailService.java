package com.poo.atividade_refac.services;

import com.poo.atividade_refac.contracts.EmailOperations;
import org.springframework.stereotype.Service;

@Service
public class EmailService implements EmailOperations {
    @Override
    public void enviarEmailPromocional() {
        // Ponto de integração: substituir pelo envio real de e-mail.
        System.out.println("Email promocional enviado");
    }
}
