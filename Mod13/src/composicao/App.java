package composicao;

public class App {
    public static void main(String[] args) {

     Banco banco = new Banco();

     banco.setCodigo(10L);
     banco.setNome("Banco do Brasil");

     ContaCorrente cc = new ContaCorrente();
     cc.setBanco(banco);
     cc.setSaldo(10d);

     ContaPoupanca cp = new ContaPoupanca();
     cp.setBanco(banco);
     cp.setSaldo(150d);

     banco.add(cc);
     banco.add(cp);

    }
}
