package br.com.sminato.exceptions.exemplo2;

public class ClienteService {

    public static void consultarCliente(String codigo) throws ClienteNaoEncontradoException {
        ClienteDAO.consultarCliente(codigo);
    }
}
