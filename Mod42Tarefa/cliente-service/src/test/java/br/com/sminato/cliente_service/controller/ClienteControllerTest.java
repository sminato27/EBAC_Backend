package br.com.sminato.cliente_service.controller;

import br.com.sminato.cliente_service.domain.Cliente;
import br.com.sminato.cliente_service.usecase.BuscaCliente;
import br.com.sminato.cliente_service.usecase.CadastroCliente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class ClienteControllerTest {

    private ClienteController controller;

    @Mock
    private BuscaCliente buscaCliente;

    @Mock
    private CadastroCliente cadastroCliente;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        controller = new ClienteController(buscaCliente, cadastroCliente);
    }

    @Test
    void buscarPorId() {
        Cliente cliente = Cliente.builder()
                .id("1")
                .nome("Minato 1")
                .cpf(12345678901L)
                .email("minato@test.com")
                .build();

        when(buscaCliente.buscarPorId("1")).thenReturn(cliente);

        var response = controller.buscarPorId("1");
        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getId()).isEqualTo("1");
        assertThat(response.getBody().getNome()).isEqualTo("Minato 1");
    }
}
