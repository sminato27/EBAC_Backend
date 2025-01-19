public class Exemplos {
    // Variáveis declaradas em escopo de classe (podem ser acessadas por toda a classe e métodos)
    private int codigo;
    private long codigoMaior;
    private float valorDecimal;
    private double valorDecimal1;
    private String texto;
    private boolean status;
    private short shor;
    private byte by;

    public Exemplos() {

    }

    /*
    Construtor, serve para quando você quer inicializar uma instância dessa classe com algum valor já definido, invés de
    definir o valor direto na variável da classe.
     */
    public Exemplos(int val) {
        this.codigo = val;
    }

    public String retornaTexto() {
        return "Texto";
    }

    public int retornaInteiro() {
        int val = 10; /* Variável declarada em escopo de método(só pode ser acessada dentro do método) */
        return val;
    }

    public long retornaLong(long num) {
        return num;
    }
}
