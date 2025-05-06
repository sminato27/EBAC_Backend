package TarefaPadroesDeProjeto.app;

import TarefaPadroesDeProjeto.factories.GUIFactory;
import TarefaPadroesDeProjeto.factories.WindowsFactory;
import TarefaPadroesDeProjeto.factories.MacOSFactory;

/**
 * Classe de demonstração, tudo se junta aqui.
 */

public class Demo {

    /**
     * A application escolhe o tipo da factory e cria em tempo de execução, dependendo da configuração ou variáveis de
     * ambiente.
     * @return
     */

    private static Application configApplication() {
        Application app;
        GUIFactory factory;

        String osName = System.getProperty("os.name").toLowerCase();

        if (osName.contains("mac")) {
            factory = new MacOSFactory();
        } else {
            factory = new WindowsFactory();
        }
        app = new Application(factory);
        return app;

    }

    public static void main(String[] args) {
        Application app = configApplication();
        app.paint();
    }
}
