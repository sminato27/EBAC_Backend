package TarefaPadroesDeProjeto.aplicacao;
import TarefaPadroesDeProjeto.carroLuxo.ICarroLuxo;
import TarefaPadroesDeProjeto.carroPopular.ICarroPopular;
import TarefaPadroesDeProjeto.fabricas.IFabricaCarros;

public class Cliente {

    private ICarroLuxo carroLuxo;
    private ICarroPopular carroPopular;

    public Cliente(IFabricaCarros fabricaCarros) {
        carroLuxo = fabricaCarros.criaCarroLuxo();
        carroPopular = fabricaCarros.criaCarroPopular();
    }

    public void dirigir(){
        carroLuxo.dirigirAutomatico();
        carroPopular.dirigir();
    }
}
