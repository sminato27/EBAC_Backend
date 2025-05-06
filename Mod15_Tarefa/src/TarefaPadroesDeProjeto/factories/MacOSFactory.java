package TarefaPadroesDeProjeto.factories;

import TarefaPadroesDeProjeto.button.Button;
import TarefaPadroesDeProjeto.button.MacOSButton;
import TarefaPadroesDeProjeto.checkbox.Checkbox;
import TarefaPadroesDeProjeto.checkbox.MacOSCheckbox;

/**
 * Cada Factory concreta estende da factory principal e é responsável por criar produtos de apenas uma variedade,
 * nesse caso, é uma factory do MacOS.
 */

public class MacOSFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacOSCheckbox();
    }
}
