package br.com.sminato.dao;

import br.com.sminato.domain.Cliente;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
// DAO =  Data Access Object
public class ClienteMapDAO implements IClienteDAO {

    // Map para guardar as informações
    private Map<String, Cliente> map;

    // Construtor do Map
    public ClienteMapDAO() {
        // Criação da lista usando HashMap
        this.map = new HashMap<>();
    }

    // Method para cadastrar um cliente
    @Override
    public Boolean cadastrar(Cliente cliente) {
        // Se dentro do map de cliente tiver o CPF informado, ele retorna falso e não continua
        // .containsKey checa se a Key dentro do () existe dentro do Map
        if (this.map.containsKey(cliente.getCpf())) {
            return false;
        }
        // Se não tiver o CPF, ele retorna verdadeiro e adiciona no Map a chave do CPF
        // .put adiciona no Map
        this.map.put(cliente.getCpf(), cliente);
        return true;
    }

    @Override
    public void excluir(String cpf) {
        // Adiciona o cpf na variável clienteCadastrado usando o map.get(cpf) == (Long cpf)
        Cliente clienteCadastrado = this.map.get(cpf);

        // Se dentro da variável clienteCadastrado tiver alguma informação, usa o map.remove() para remover
        if (clienteCadastrado != null) {
            this.map.remove(clienteCadastrado.getCpf(), clienteCadastrado);
        }
    }

    @Override
    public void alterar(Cliente cliente) {
        atualizarDadosCliente(cliente);
    }

    private void atualizarDadosCliente(Cliente cliente) {
        // Adiciona o cpf na variável clienteCadastrado usando o map.get(cliente.getCpf) == (Cliente cliente)
        Cliente clienteCadastrado = this.map.get(cliente.getCpf());
        // Se dentro da variável clienteCadastrado tiver alguma informação, altera as informações usando .set()
        // pela informação que está vindo no .get() (o .get é a informação que o usuário inseriu)
        if (clienteCadastrado != null) {
            // Ternário pra checar se o usuário não inseriu informações vazias
            clienteCadastrado.setNome(cliente.getNome().isEmpty() ? clienteCadastrado.getNome() : cliente.getNome());
            clienteCadastrado.setTel(cliente.getTel().isEmpty() ? clienteCadastrado.getTel() : cliente.getTel());
            clienteCadastrado.setNumero(cliente.getNumero().isEmpty() ? clienteCadastrado.getNumero() : cliente.getNumero());
            clienteCadastrado.setEnd(cliente.getEnd().isEmpty() ? clienteCadastrado.getEnd() : cliente.getEnd());
            clienteCadastrado.setCidade(cliente.getCidade().isEmpty() ? clienteCadastrado.getCidade() : cliente.getCidade());
            clienteCadastrado.setEstado(cliente.getEstado().isEmpty() ? clienteCadastrado.getEstado() : cliente.getEstado());
        }
    }

    @Override
    public Cliente consultar(String cpf) {
        // Consulta o cpf, se tiver dentro do Map, retorna o CPF, senão retorna null
        return this.map.get(cpf);
    }

    @Override
    public Collection<Cliente> buscarTodos() {
        //Retorna a collection de clientes
        return this.map.values();
    }
}