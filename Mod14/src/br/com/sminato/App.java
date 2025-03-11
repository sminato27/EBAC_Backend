package br.com.sminato;

import br.com.sminato.dao.IClienteDAO;
import br.com.sminato.dao.ClienteMapDAO;
import br.com.sminato.domain.Cliente;

import javax.swing.*;

public class App {

    private static IClienteDAO iClienteDAO;

    public static void main(String[] args) {
        iClienteDAO = new ClienteMapDAO();

        String opcao = JOptionPane.showInputDialog(null, "Digite '1' para cadastrar, " +
                        "'2' para consultar, '3' para excluir, '4' para alterar ou '5' para sair.",
                "Tela inicial", JOptionPane.INFORMATION_MESSAGE);

        /* Forma de validar se o número digitado é igual ao mencionado.
        if ("1".equals(opcao)) {
            JOptionPane.showMessageDialog(null, "Opção: " + opcao, "Erro!", JOptionPane.INFORMATION_MESSAGE);\
            }
         */

        while (!isOpcaoValida(opcao)) {
            if ("".equals(opcao)) {
                sair();
            }
            opcao = JOptionPane.showInputDialog(null, "Opção inválida! Digite '1' para cadastrar, " +
                            "'2' para consultar, '3' para excluir, '4' para alterar ou '5' para sair.",
                    "Tela inicial", JOptionPane.INFORMATION_MESSAGE);
        }

        /* Forma de criar um métod0 para uma opção específica
        if (isOpcaoCadastro(opcao)) {
            JOptionPane.showMessageDialog(null, "Opção: " + opcao, "Erro!", JOptionPane.INFORMATION_MESSAGE);
        }
         */

        while (isOpcaoValida(opcao)) {
            if (isOpcaoSair(opcao)) {
                sair();
            } else if (isOpcaoCadastro(opcao)) {
                String dados = JOptionPane.showInputDialog(null, "Digite os dados do cliente separados " +
                                "por vírgula, conforme exemplo: Nome,CPF,Telefone,Endereço,Número,Cidade,Estado",
                        "Tela de Cadastro", JOptionPane.INFORMATION_MESSAGE);
                cadastrar(dados);
            } else if (isOpcaoConsultar(opcao)) {
                String dados = JOptionPane.showInputDialog(null, "Digite o CPF que deseja consultar:",
                        "Tela de Consulta", JOptionPane.INFORMATION_MESSAGE);
                consultar(dados);
            } else if (isOpcaoExcluir(opcao)) {
                String dados = JOptionPane.showInputDialog(null, "Digite o CPF que deseja excluir:",
                        "Tela de Exclusão", JOptionPane.INFORMATION_MESSAGE);
                excluir(dados);
            } else if (isOpcaoAlterar(opcao)) {
                String dados = JOptionPane.showInputDialog(null, "Digite o CPF que deseja alterar os dados:",
                        "Tela de Alteração dos dados", JOptionPane.INFORMATION_MESSAGE);
                alterarDadosCliente(dados);
            }

            opcao = JOptionPane.showInputDialog(null, "Digite '1' para cadastrar, " +
                            "'2' para consultar, '3' para excluir, '4' para alterar ou '5' para sair.",
                    "Tela inicial", JOptionPane.INFORMATION_MESSAGE);
        }

    }


    // OPÇÕES
    private static boolean isOpcaoCadastro (String opcao){
        if ("1".equals(opcao)) {
            return true;
        }
        return false;
    }

    private static boolean isOpcaoConsultar (String opcao){
        if ("2".equals(opcao)) {
            return true;
        }
        return false;
    }

    private static boolean isOpcaoExcluir (String opcao){
        if ("3".equals(opcao)) {
            return true;
        }
        return false;
    }

    private static boolean isOpcaoAlterar (String opcao){
        if ("4".equals(opcao)) {
            return true;
        }
        return false;
    }

    private static boolean isOpcaoSair(String opcao) {
        if ("5".equals(opcao)) {
            return true;
        }
        return false;
    }

    // MÉTOD0S
    // Métod0 para alterar os dados
    private static void alterarDadosCliente(String CPF1) {
        Cliente cliente = iClienteDAO.consultar(CPF1);

        if (cliente == null) {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado.", "Erro", JOptionPane.INFORMATION_MESSAGE);
        } else {
            Cliente clienteAtualizado = getDadosClientes();
            clienteAtualizado.setCpf(cliente.getCpf());
            iClienteDAO.alterar(clienteAtualizado);
        }

    }

    // Métod0 para excluir os dados
    private static void excluir(String dados) {
        Cliente cliente = iClienteDAO.consultar((dados));

        if (cliente != null) {
            iClienteDAO.excluir((dados));
            JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "CPF não encontrado para exclusão.", "Erro", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // Métod0 para consultar os dados
    private static void consultar(String dados) {
        // Pode-se validar se foi passado somente o CPF, se foi passado algum outro caractére, dará erro
        Cliente cliente = iClienteDAO.consultar((dados));
        if (cliente != null) {
            JOptionPane.showMessageDialog(null, "Cliente encontrado: " + cliente.toString(), "Consultado com sucesso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado.", "Erro", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    // Métod0 para cadastrar os dados
    private static void cadastrar(String dados) {
        String[] dadosSeparados = dados.split(",");
        // Tentar validar se todos os campos estão preenchidos
        // Se não estiverem, passar null no construtor onde o valor é nulo
        // Exemplo: Cliente cliente = new Cliente(dadosSeparados[0],null,dadosSeparados[2],...
        Cliente cliente = new Cliente(dadosSeparados[0], (dadosSeparados[1]), (dadosSeparados[2]), dadosSeparados[3], (dadosSeparados[4]), dadosSeparados[5], dadosSeparados[6]);
        Boolean isCadastrado = iClienteDAO.cadastrar(cliente);
        if (isCadastrado) {
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro, o cliente não foi cadastrado.", "Erro", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // Métod0 para sair do programa, mostra a mensagem e sai.
    private static void sair() {
        JOptionPane.showMessageDialog(null, "Até logo!", "Sair", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

    // Métod0 que checa se a opção digitada é válida
    private static boolean isOpcaoValida(String opcao) {
        if ("1".equals(opcao) || "2".equals(opcao) || "3".equals(opcao) || "4".equals(opcao) || "5".equals(opcao)) {
            return true;
        }
        return false;
    }

    private static Cliente getDadosClientes() {
        String[] campos = new String[]{"nome", "tel", "endereco", "numero", "cidade", "estado"};
        String[] respostasUsuario = new String[campos.length];

        for (int i = 0; i < campos.length; i++) {
            respostasUsuario[i] = JOptionPane.showInputDialog(null, "Informe o novo " + campos[i] + ":", "atualização dados cliente", JOptionPane.INFORMATION_MESSAGE).trim();
        }

        Cliente result = new Cliente(respostasUsuario[0], "", respostasUsuario[1], respostasUsuario[2], respostasUsuario[3], respostasUsuario[4], respostasUsuario[5]);

        return result;
    }
}
