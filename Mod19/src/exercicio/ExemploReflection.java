package exercicio;

public class ExemploReflection {

    public static void main(String[] args) {
        Class<ClasseAnotacao> clazz = ClasseAnotacao.class;

        if (clazz.isAnnotationPresent(ITabela.class)) {
            ITabela anotacao = clazz.getAnnotation(ITabela.class);
            String valor = anotacao.value();
            System.out.println("Valor da anotação @ITabela: " + valor);
        } else {
            System.out.println("A anotação @ITabela não está presente na classe ClasseAnotacao.");
        }
    }
}
