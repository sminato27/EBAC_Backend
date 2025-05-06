package TarefaPadroesDeProjeto.fabricas;

import TarefaPadroesDeProjeto.carroLuxo.ToyotaLuxo;
import TarefaPadroesDeProjeto.carroLuxo.ICarroLuxo;
import TarefaPadroesDeProjeto.carroPopular.ToyotaPopular;
import TarefaPadroesDeProjeto.carroPopular.ICarroPopular;

public class FabricaToyota implements IFabricaCarros{

    @Override
    public ICarroLuxo criaCarroLuxo() {
        return new ToyotaLuxo();
    }

    @Override
    public ICarroPopular criaCarroPopular() {
        return new ToyotaPopular();
    }
}
