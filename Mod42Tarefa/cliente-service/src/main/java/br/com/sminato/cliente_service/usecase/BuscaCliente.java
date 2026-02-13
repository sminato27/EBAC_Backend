package br.com.sminato.cliente_service.usecase;

import br.com.sminato.cliente_service.domain.Cliente;
import br.com.sminato.cliente_service.exception.EntityNotFoundException;
import br.com.sminato.cliente_service.repository.IClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BuscaCliente {

    private final IClienteRepository repository;

    public Page<Cliente> buscar(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Cliente buscarPorId(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente was not found for id=" + id));
    }

    public Boolean isCadastrado(String id) {
        return repository.findById(id).isPresent();
    }

    public Cliente buscarPorCpf(Long cpf) {
        return repository.findByCpf(cpf)
                .orElseThrow(() -> new EntityNotFoundException("Cliente was not found for cpf=" + cpf));
    }
}
