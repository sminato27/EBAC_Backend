package TarefaPadroesDeProjeto.fabricas;

import TarefaPadroesDeProjeto.carroLuxo.ICarroLuxo;
import TarefaPadroesDeProjeto.carroPopular.ICarroPopular;

public interface IFabricaCarros {

    ICarroLuxo criaCarroLuxo();
    ICarroPopular criaCarroPopular();

}
