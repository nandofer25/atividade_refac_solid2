package com.poo.atividade_refac.services;

import com.poo.atividade_refac.entities.Livro;
import com.poo.atividade_refac.repositories.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {
    private final LivroRepository livroRepository;
    private final DescontoService descontoService;
    private final RelatorioService relatorioService;
    private final EmailService emailService;

    public LivroService(
            LivroRepository livroRepository,
            DescontoService descontoService,
            RelatorioService relatorioService,
            EmailService emailService) {
        this.livroRepository = livroRepository;
        this.descontoService = descontoService;
        this.relatorioService = relatorioService;
        this.emailService = emailService;
    }

    public List<Livro> listar() {
        return livroRepository.findAll();
    }

    public Livro cadastrar(Livro livro) {
        validarLivro(livro);
        descontoService.aplicarDesconto(livro);

        Livro salvo = livroRepository.save(livro);
        relatorioService.gerarRelatorio();
        emailService.enviarEmailPromocional();
        return salvo;
    }

    public Livro atualizar(Long id, Livro dados) {
        validarLivro(dados);
        Livro existente = buscarPorId(id);

        existente.setTitulo(dados.getTitulo());
        existente.setAutor(dados.getAutor());
        existente.setPreco(dados.getPreco());
        existente.setCategoria(dados.getCategoria());

        return livroRepository.save(existente);
    }

    public void remover(Long id) {
        Livro livro = buscarPorId(id);

        if ("RARO".equalsIgnoreCase(livro.getCategoria())) {
            throw new RegraNegocioException(
                    "Livros raros não podem ser removidos");
        }

        livroRepository.delete(livro);
    }

    private Livro buscarPorId(Long id) {
        return livroRepository.findById(id)
                .orElseThrow(() -> new LivroNaoEncontradoException(id));
    }

    private void validarLivro(Livro livro) {
        if (livro == null) {
            throw new RegraNegocioException("Os dados do livro são obrigatórios");
        }
        if (livro.getTitulo() == null || livro.getTitulo().isBlank()) {
            throw new RegraNegocioException("Título obrigatório");
        }
        if (livro.getPreco() == null || livro.getPreco() <= 0) {
            throw new RegraNegocioException("Preço inválido");
        }
    }
}
