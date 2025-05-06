package TarefaPadroesDeProjeto.checkbox;

/**
 * Todas as famílias de produtos tem as mesmas variedades (MacOS/Windows).
 *
 * Essa é a variante do Checkbox para MacOS.
 */

public class MacOSCheckbox implements Checkbox {

    @Override
    public void paint() {
        System.out.println("Você criou uma MacOSCheckbox!");
    }
}
