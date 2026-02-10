package br.com.sminato.mod40.repositories;

import br.com.sminato.mod40.domain.Produto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProdutoRepository extends CrudRepository<Produto, Long> {

}
