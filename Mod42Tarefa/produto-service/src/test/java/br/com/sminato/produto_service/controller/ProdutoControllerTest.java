package br.com.sminato.produto_service.controller;

import br.com.sminato.produto_service.domain.Produto;
import br.com.sminato.produto_service.usecase.BuscaProduto;
import br.com.sminato.produto_service.usecase.CadastroProduto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.anyString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class ProdutoControllerTest {

    private ProdutoController controller;

    @Mock
    private BuscaProduto buscaProduto;

    @Mock
    private CadastroProduto cadastroProduto;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        controller = new ProdutoController(buscaProduto, cadastroProduto);
    }

    @Test
    void buscarPorCodigo() {
        Produto produto = Produto.builder()
                .id("1")
                .codigo("PROD1")
                .nome("Produto 1")
                .build();

        when(buscaProduto.buscarPorCodigo(anyString())).thenReturn(produto);

        var response = controller.buscarPorCodigo("PROD1");
        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getCodigo()).isEqualTo("PROD1");
        assertThat(response.getBody().getNome()).isEqualTo("Produto 1");
    }
}
