package br.com.sminato.dao;

import br.com.sminato.domain.Carro;
import java.util.List;

public interface ICarroDao {
    Carro cadastrar(Carro carro);
    List<Carro> buscarPorMarca(String nomeMarca);
    List<Carro> buscarPorAcessorio(String descricaoAcessorio);
}
