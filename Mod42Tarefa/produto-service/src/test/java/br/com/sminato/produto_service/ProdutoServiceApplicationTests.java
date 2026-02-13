package br.com.sminato.produto_service;

import br.com.sminato.produto_service.repository.IProdutoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

@SpringBootTest
class ProdutoServiceApplicationTests {

	@MockitoBean
	private IProdutoRepository produtoRepository;

	@Test
	void contextLoads() {
	}

}
