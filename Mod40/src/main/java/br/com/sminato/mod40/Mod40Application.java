package br.com.sminato.mod40;

import br.com.sminato.mod40.domain.Cliente;
import br.com.sminato.mod40.domain.Produto;
import br.com.sminato.mod40.repositories.IClienteRepository;
import br.com.sminato.mod40.repositories.IProdutoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@Configuration
@EnableJpaRepositories(basePackages = "br.com.sminato.mod40.repositories")
@EntityScan(basePackages = "br.com.sminato.mod40.*")
@ComponentScan(basePackages = "br.com.sminato.mod40.*")
public class Mod40Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Mod40Application.class, args);
	}

	private static Logger log = LoggerFactory.getLogger(Mod40Application.class);

	@Autowired
	private IClienteRepository repository;
	@Autowired
	private IProdutoRepository repositoryProduto;

	@Override
	public void run(String... args) throws Exception {
		log.info("Iniciando aplicação Mod40");
		Cliente cliente = createCliente();
		Produto produto = createProduto();
		repository.save(cliente);
		repositoryProduto.save(produto);
	}

	private Produto createProduto() {
		return Produto.builder()
				.nome("Produto Teste")
				.valor(100.0)
				.descricao("Descrição do produto teste")
				.codigo("PROD001")
				.build();
	}

	private Cliente createCliente() {
		return Cliente.builder()
				.nome("Minato")
				.telefone(99999999999L)
				.cpf(99999999999L)
				.email("test@test.com")
				.cidade("Tubarão")
				.endereco("R. Tal do Fulano de Tal, 764")
				.estado("SC")
				.build();
	}
}
