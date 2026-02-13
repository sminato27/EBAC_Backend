package br.com.sminato.cliente_service.usecase;

import br.com.sminato.cliente_service.domain.Cliente;
import br.com.sminato.cliente_service.repository.IClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CadastroCliente {

    private final IClienteRepository repository;

    public Cliente cadastrar(Cliente cliente) {
        return repository.insert(cliente);
    }

    public Cliente atualizar(Cliente cliente) {
        return repository.save(cliente);
    }

    public void remover(String id) {
        repository.deleteById(id);
    }
}
