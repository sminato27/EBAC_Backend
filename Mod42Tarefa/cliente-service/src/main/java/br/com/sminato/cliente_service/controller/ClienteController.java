package br.com.sminato.cliente_service.controller;

import br.com.sminato.cliente_service.domain.Cliente;
import br.com.sminato.cliente_service.usecase.BuscaCliente;
import br.com.sminato.cliente_service.usecase.CadastroCliente;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")
@RequiredArgsConstructor
public class ClienteController {

    private final BuscaCliente buscaCliente;
    private final CadastroCliente cadastroCliente;

    @GetMapping
    @Operation(summary = "Busca todos os clientes paginados")
    public ResponseEntity<Page<Cliente>> buscar(Pageable pageable) {
        return ResponseEntity.ok(buscaCliente.buscar(pageable));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca um cliente pelo id")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable String id) {
        return ResponseEntity.ok(buscaCliente.buscarPorId(id));
    }

    @GetMapping("/isCadastrado/{id}")
    @Operation(summary = "Verifica se um cliente está cadastrado")
    public ResponseEntity<Boolean> isCadastrado(@PathVariable String id) {
        return ResponseEntity.ok(buscaCliente.isCadastrado(id));
    }

    @GetMapping("/cpf/{cpf}")
    @Operation(summary = "Busca um cliente pelo CPF")
    public ResponseEntity<Cliente> buscarPorCpf(@PathVariable Long cpf) {
        return ResponseEntity.ok(buscaCliente.buscarPorCpf(cpf));
    }

    @PostMapping
    @Operation(summary = "Cadastra um novo cliente")
    public ResponseEntity<Cliente> cadastrar(@RequestBody @Valid Cliente cliente) {
        return ResponseEntity.ok(cadastroCliente.cadastrar(cliente));
    }

    @PutMapping
    @Operation(summary = "Atualiza um cliente existente")
    public ResponseEntity<Cliente> atualizar(@RequestBody @Valid Cliente cliente) {
        return ResponseEntity.ok(cadastroCliente.atualizar(cliente));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove um cliente pelo id")
    public ResponseEntity<String> remover(@PathVariable String id) {
        cadastroCliente.remover(id);
        return ResponseEntity.ok("Removido com sucesso");
    }
}
