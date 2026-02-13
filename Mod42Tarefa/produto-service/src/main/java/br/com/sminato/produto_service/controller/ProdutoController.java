package br.com.sminato.produto_service.controller;

import br.com.sminato.produto_service.domain.Produto;
import br.com.sminato.produto_service.domain.Status;
import br.com.sminato.produto_service.usecase.BuscaProduto;
import br.com.sminato.produto_service.usecase.CadastroProduto;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produto")
@RequiredArgsConstructor
public class ProdutoController {

    private final BuscaProduto buscaProduto;
    private final CadastroProduto cadastroProduto;

    @GetMapping
    @Operation(summary = "Busca todos os produtos paginados")
    public ResponseEntity<Page<Produto>> buscar(Pageable pageable) {
        return ResponseEntity.ok(buscaProduto.buscar(pageable));
    }

    @GetMapping("/status/{status}")
    @Operation(summary = "Busca produtos por status")
    public ResponseEntity<Page<Produto>> buscarPorStatus(Pageable pageable, @PathVariable Status status) {
        return ResponseEntity.ok(buscaProduto.buscar(pageable, status));
    }

    @GetMapping("/{codigo}")
    @Operation(summary = "Busca um produto pelo código")
    public ResponseEntity<Produto> buscarPorCodigo(@PathVariable String codigo) {
        return ResponseEntity.ok(buscaProduto.buscarPorCodigo(codigo));
    }

    @PostMapping
    @Operation(summary = "Cadastra um novo produto")
    public ResponseEntity<Produto> cadastrar(@RequestBody @Valid Produto produto) {
        return ResponseEntity.ok(cadastroProduto.cadastrar(produto));
    }

    @PutMapping
    @Operation(summary = "Atualiza um produto existente")
    public ResponseEntity<Produto> atualizar(@RequestBody @Valid Produto produto) {
        return ResponseEntity.ok(cadastroProduto.atualizar(produto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove (soft delete) um produto pelo id")
    public ResponseEntity<String> remover(@PathVariable String id) {
        cadastroProduto.remover(id);
        return ResponseEntity.ok("Removido com sucesso");
    }
}
