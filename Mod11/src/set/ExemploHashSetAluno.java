package set;

import domain.Aluno;

import java.util.HashSet;
import java.util.Set;

public class ExemploHashSetAluno {
    public static void main(String[] args) {
        exemploListaSimples();
        exemploConsultando();
        exemploRemover();
    }

    /**
     * Para não repetir objetos na lista de alunos é necessário que a classe Aluno implemente o equals e hashcode.
     */

    private static void exemploListaSimples() {
        System.out.println("*** exemploListaSimples ***");
        Set<Aluno> conjunto = new HashSet<>();

        Aluno a = new Aluno("Joao da Silva", "Linux Basico", 0);
        Aluno b = new Aluno("Antonio Sousa", "OpenOffice", 0);
        Aluno c = new Aluno("Lucia Ferreira", "Internet", 0);
        Aluno d = new Aluno("Antonio Sousa", "OpenOffice", 0);
        conjunto.add(a);
        conjunto.add(b);
        conjunto.add(c);
        conjunto.add(d);
        System.out.println(conjunto);
        System.out.println("");
    }

    private static void exemploConsultando() {
        System.out.println("*** exemploConsultando ***");
        Set<Aluno> conjunto = new HashSet<>();

        Aluno a = new Aluno("Joao da Silva", "Linux Basico", 0);
        Aluno b = new Aluno("Antonio Sousa", "OpenOffice", 0);
        Aluno c = new Aluno("Lucia Ferreira", "Internet", 0);
        Aluno d = new Aluno("Antonio Sousa", "OpenOffice", 0);
        conjunto.add(a);
        conjunto.add(b);
        conjunto.add(c);
        conjunto.add(d);
        System.out.println(conjunto.contains(a));
        System.out.println("");
    }

    public static void exemploRemover() {
        System.out.println("*** exemploRemover ***");
        Set<Aluno> conjunto = new HashSet<>();

        Aluno a = new Aluno("Joao da Silva", "Linux Basico", 0);
        Aluno b = new Aluno("Antonio Sousa", "OpenOffice", 0);
        Aluno c = new Aluno("Lucia Ferreira", "Internet", 0);
        Aluno d = new Aluno("Antonio Sousa", "OpenOffice", 0);
        conjunto.add(a);
        conjunto.add(b);
        conjunto.add(c);
        conjunto.add(d);
        System.out.println(conjunto);

        conjunto.remove(c);
        System.out.println(conjunto);
        System.out.println("");

        /**
         * Percorre a lista "conjunto", pega cada item e joga na variável "aluno".
         */
        for (Aluno aluno : conjunto) {
            System.out.println(aluno);
        }
    }
}
