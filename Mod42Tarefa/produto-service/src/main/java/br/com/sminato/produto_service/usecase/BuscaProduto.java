package br.com.sminato.produto_service.usecase;

import br.com.sminato.produto_service.domain.Produto;
import br.com.sminato.produto_service.domain.Status;
import br.com.sminato.produto_service.exception.EntityNotFoundException;
import br.com.sminato.produto_service.repository.IProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BuscaProduto {

    private final IProdutoRepository repository;

    public Page<Produto> buscar(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Page<Produto> buscar(Pageable pageable, Status status) {
        return repository.findAllByStatus(pageable, status);
    }

    public Produto buscarPorCodigo(String codigo) {
        return repository.findByCodigo(codigo)
                .orElseThrow(() -> new EntityNotFoundException("Produto was not found for codigo=" + codigo));
    }

    public Produto buscarPorId(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Produto was not found for id=" + id));
    }
}
