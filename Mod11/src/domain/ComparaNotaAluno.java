package domain;

import java.util.Comparator;

/**
 * Comparator: Use-o quando precisar de uma ordenação específica em tempo de execução, ou quando não quiser modificar a
 * classe dos objetos que está ordenando. Por exemplo, se você tiver uma classe `Aluno` e quiser ordená-los por idade,
 * mas também quiser poder ordená-los por nome ou por qualquer outro critério em diferentes situações, você
 * implementaria `Comparator` para cada critério de ordenação diferente que precisar. Isso permite uma maior
 * flexibilidade e reutilização de código.
 */
public class ComparaNotaAluno implements Comparator<Aluno> {

    /**
     * Ordena de forma ascendente. Caso queira mudar para descendente, altera-se a ordem dos parâmetros no método.
     * @param o1 the first object to be compared.
     * @param o2 the second object to be compared.
     * @return int compare();
     */
    @Override
    public int compare(Aluno o1, Aluno o2) {
        return Double.compare(o1.getNota(), o2.getNota());
    }
}
