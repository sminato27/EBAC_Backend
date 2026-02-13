package br.com.sminato.cliente_service.repository;

import br.com.sminato.cliente_service.domain.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IClienteRepository extends MongoRepository<Cliente, String> {
    Optional<Cliente> findByCpf(Long cpf);
}
