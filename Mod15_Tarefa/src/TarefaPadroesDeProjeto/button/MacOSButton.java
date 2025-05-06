package TarefaPadroesDeProjeto.button;

/**
 * Todas as famílias de produtos tem as mesmas variedades (MacOS/Windows).
 *
 * Essa é a variante do Button para MacOS.
 */

public class MacOSButton implements Button {

    @Override
    public void paint() {
        System.out.println("Você criou um MacOSButton!");
    }
}
