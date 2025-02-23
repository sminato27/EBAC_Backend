package Tarefa;

public class Tarefa {
    public static void main(String[] args) {
        PessoaFisica pessoaf = new PessoaFisica();
        pessoaf.setNome("Guilherme");
        pessoaf.setSobrenome("Paim");
        pessoaf.setCpf("004.944.257-71");
        imprimirFisico(pessoaf);

        PessoaJuridica pessoaj = new PessoaJuridica();
        pessoaj.setNome("Lilian");
        pessoaj.setSobrenome("Bonatto");
        pessoaj.setMei("49.123.456/0001-78");
        imprimirJuridica(pessoaj);

    }

    public static void imprimirFisico (PessoaFisica pessoa) {
        System.out.println(pessoa.getNome() + " " + pessoa.getSobrenome() + " " + pessoa.getCpf());
    }

    public static void imprimirJuridica (PessoaJuridica pessoa) {
        System.out.println(pessoa.getNome() + " " + pessoa.getSobrenome() + " " + pessoa.getMei());
    }
}
