package TarefaPadroesDeProjeto.app;

import TarefaPadroesDeProjeto.button.Button;
import TarefaPadroesDeProjeto.checkbox.Checkbox;
import TarefaPadroesDeProjeto.factories.GUIFactory;

/**
 * Os usuários da Factory não se importam sobre qual factory concreta eles usam desde que eles possam trabalhar com as
 * factories e produtos pelas interfaces abstratas.
 */

public class Application {

    private Button button;
    private Checkbox checkbox;

    public Application(GUIFactory factory) {
        button = factory.createButton();
        checkbox = factory.createCheckbox();
    }

    public void paint() {
        button.paint();
        checkbox.paint();
    }
}
