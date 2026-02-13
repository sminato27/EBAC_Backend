package br.com.sminato.produto_service.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(collection = "produto")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "Produto", description = "Entidade de Produto")
public class Produto {

    @Id
    @Schema(description = "Identificador único")
    private String id;

    @NotNull
    @Size(min = 2, max = 10)
    @Indexed(unique = true, background = true)
    @Schema(description = "Código do produto", requiredMode = Schema.RequiredMode.REQUIRED)
    private String codigo;

    @NotNull
    @Size(min = 1, max = 50)
    @Schema(description = "Nome do produto", requiredMode = Schema.RequiredMode.REQUIRED)
    private String nome;

    @NotNull
    @Size(min = 1, max = 50)
    @Schema(description = "Descrição do produto", requiredMode = Schema.RequiredMode.REQUIRED)
    private String descricao;

    @Schema(description = "Valor do produto")
    private BigDecimal valor;

    @Schema(description = "Status do produto")
    private Status status;
}
