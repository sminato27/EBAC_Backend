package TarefaPadroesDeProjeto.factories;

import TarefaPadroesDeProjeto.button.Button;
import TarefaPadroesDeProjeto.checkbox.Checkbox;

/**
 * A Factory abstrata sabe de todos tipos de produtos abstratos.
 */

public interface GUIFactory {

    Button createButton();
    Checkbox createCheckbox();

}
