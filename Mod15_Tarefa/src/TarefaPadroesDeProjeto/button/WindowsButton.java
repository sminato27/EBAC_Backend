package TarefaPadroesDeProjeto.button;

/**
 * Todas as famílias de produtos tem as mesmas variedades (MacOS/Windows).
 *
 * Essa é a variante do Button para Windows.
 */

public class WindowsButton implements Button {

    @Override
    public void paint() {
        System.out.println("Você criou um WindowsButton!");
    }
}
