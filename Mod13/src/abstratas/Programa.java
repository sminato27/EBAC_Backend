package abstratas;

public class Programa {
    public static void main(String[] args) {

        Assalariado empregado = new Assalariado();
        empregado.setCpf("1");
        empregado.setNome("Matheus");
        empregado.setSobrenome("Silva");
        empregado.setSalario(199d);

        imprimir(empregado);

        Comissionado comissionado = new Comissionado();
        comissionado.setCpf("2");
        comissionado.setNome("Roger");
        comissionado.setSobrenome("Alves");
        comissionado.setTotalVenda(1000d);
        comissionado.setTotalComissao(01d);

        imprimir(comissionado);

        Horista horista = new Horista();
        horista.setCpf("3");
        horista.setNome("Erica");
        horista.setSobrenome("Barnes");
        horista.setPrecoHora(80d);
        horista.setTotalHoraTrabalhada(60d);

        imprimir(horista);


    }

    public static void imprimir (Empregado empregado) {
        System.out.println(empregado.getNome() + " " + empregado.getSobrenome() +  " tem de salário: " + empregado.vencimento());
        empregado.imprimirSobrenome();
        empregado.imprimirValores();
    }
}
