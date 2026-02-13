package br.com.sminato.cliente_service;

import br.com.sminato.cliente_service.repository.IClienteRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

@SpringBootTest
class ClienteServiceApplicationTests {

	@MockitoBean
	private IClienteRepository clienteRepository;

	@Test
	void contextLoads() {
	}

}
