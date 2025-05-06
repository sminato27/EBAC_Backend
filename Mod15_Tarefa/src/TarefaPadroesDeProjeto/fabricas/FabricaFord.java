package TarefaPadroesDeProjeto.fabricas;

import TarefaPadroesDeProjeto.carroLuxo.ICarroLuxo;
import TarefaPadroesDeProjeto.carroLuxo.FordLuxo;
import TarefaPadroesDeProjeto.carroPopular.ICarroPopular;
import TarefaPadroesDeProjeto.carroPopular.FordPopular;

public class FabricaFord implements IFabricaCarros{
    @Override
    public ICarroLuxo criaCarroLuxo() {
        return new FordLuxo();
    }

    @Override
    public ICarroPopular criaCarroPopular() {
        return new FordPopular();
    }
}
