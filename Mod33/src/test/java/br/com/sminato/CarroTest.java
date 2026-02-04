package br.com.sminato;

import br.com.sminato.dao.*;
import br.com.sminato.domain.Acessorio;
import br.com.sminato.domain.Carro;
import br.com.sminato.domain.Marca;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CarroTest {

    private ICarroDao carroDao;
    private IMarcaDao marcaDao;
    private IAcessorioDao acessorioDao;

    public CarroTest() {
        carroDao = new CarroDao();
        marcaDao = new MarcaDao();
        acessorioDao = new AcessorioDao();
    }

    @Test
    public void cadastrar() {
        Marca marca = new Marca();
        marca.setNome("Toyota");
        marca = marcaDao.cadastrar(marca);
        assertNotNull(marca.getId());

        Acessorio rodas = new Acessorio();
        rodas.setDescricao("Rodas de Liga Leve");
        rodas = acessorioDao.cadastrar(rodas);
        assertNotNull(rodas.getId());

        Acessorio teto = new Acessorio();
        teto.setDescricao("Teto Solar");
        teto = acessorioDao.cadastrar(teto);
        assertNotNull(teto.getId());

        Carro carro = new Carro();
        carro.setModelo("Corolla");
        carro.setAno(2024);
        carro.setMarca(marca);
        
        List<Acessorio> acessorios = new ArrayList<>();
        acessorios.add(rodas);
        acessorios.add(teto);
        carro.setAcessorios(acessorios);

        carro = carroDao.cadastrar(carro);
        assertNotNull(carro.getId());
        assertNotNull(carro.getMarca());
        assertEquals(2, carro.getAcessorios().size());

        List<Carro> carrosToyota = carroDao.buscarPorMarca("Toyota");
        assertNotNull(carrosToyota);
        assertEquals(1, carrosToyota.size());
        assertEquals("Corolla", carrosToyota.get(0).getModelo());

        List<Carro> carrosComTeto = carroDao.buscarPorAcessorio("Teto Solar");
        assertNotNull(carrosComTeto);
        assertEquals(1, carrosComTeto.size());
        assertEquals("Corolla", carrosComTeto.get(0).getModelo());
    }
}
