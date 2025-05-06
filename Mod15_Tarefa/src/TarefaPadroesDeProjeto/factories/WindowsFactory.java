package TarefaPadroesDeProjeto.factories;

import TarefaPadroesDeProjeto.button.Button;
import TarefaPadroesDeProjeto.button.WindowsButton;
import TarefaPadroesDeProjeto.checkbox.Checkbox;
import TarefaPadroesDeProjeto.checkbox.WindowsCheckbox;

/**
 * Cada Factory concreta estende da factory principal e é responsável por criar produtos de apenas uma variedade,
 * nesse caso, é uma factory do Windows.
 */

public class WindowsFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}
