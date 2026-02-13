package br.com.sminato.produto_service.usecase;

import br.com.sminato.produto_service.domain.Produto;
import br.com.sminato.produto_service.domain.Status;
import br.com.sminato.produto_service.exception.EntityNotFoundException;
import br.com.sminato.produto_service.repository.IProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CadastroProduto {

    private final IProdutoRepository repository;

    public Produto cadastrar(Produto produto) {
        produto.setStatus(Status.ATIVO);
        return repository.insert(produto);
    }

    public Produto atualizar(Produto produto) {
        return repository.save(produto);
    }

    public void remover(String id) {
        Produto produto = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Produto was not found for id=" + id));
        produto.setStatus(Status.INATIVO);
        repository.save(produto);
    }
}
