package TarefaPadroesDeProjeto.aplicacao;
import TarefaPadroesDeProjeto.fabricas.IFabricaCarros;
import TarefaPadroesDeProjeto.fabricas.FabricaToyota;
import TarefaPadroesDeProjeto.fabricas.FabricaFord;
import java.util.Scanner;

public class Demo {

    private static Cliente configuraCliente() {
        Cliente cliente;
        IFabricaCarros fabricaCarros = null;

        String escolhaUser = escolhaUsuario();

        if (escolhaUser.equalsIgnoreCase("T")) {
            fabricaCarros = new FabricaToyota();
        } else if (escolhaUser.equalsIgnoreCase("F")){
            fabricaCarros = new FabricaFord();
        } else {
            System.out.println("Escolha incorreta!");
        }

        cliente = new Cliente(fabricaCarros);
        return cliente;
    }

    public static String escolhaUsuario() {
        Scanner a = new Scanner(System.in);

        System.out.println("Digite (T) para escolher um carro da Toyota ou (F) para escolher um carro da Ford: ");
        String escolhaMarca = a.next();

        return escolhaMarca;
    }

    public static void main(String[] args) {
        Cliente cliente = configuraCliente();
        cliente.dirigir();
    }
}
