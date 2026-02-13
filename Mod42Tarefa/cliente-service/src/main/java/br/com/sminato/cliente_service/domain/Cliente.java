package br.com.sminato.cliente_service.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cliente")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "Cliente", description = "Entidade de Cliente")
public class Cliente {

    @Id
    @Schema(description = "Identificador único")
    private String id;

    @NotNull
    @Size(min = 1, max = 50)
    @Schema(description = "Nome do cliente", requiredMode = Schema.RequiredMode.REQUIRED)
    private String nome;

    @NotNull
    @Indexed(unique = true, background = true)
    @Schema(description = "CPF do cliente", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long cpf;

    @NotNull
    @Schema(description = "Telefone do cliente", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long tel;

    @NotNull
    @Size(min = 1, max = 50)
    @Indexed(unique = true, background = true)
    @Pattern(regexp = ".+@.+\\..+", message = "Email inválido")
    @Schema(description = "Email do cliente", requiredMode = Schema.RequiredMode.REQUIRED)
    private String email;

    @NotNull
    @Size(min = 1, max = 50)
    @Schema(description = "Endereço do cliente", requiredMode = Schema.RequiredMode.REQUIRED)
    private String end;

    @NotNull
    @Schema(description = "Número do endereço", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer numero;

    @NotNull
    @Size(min = 1, max = 50)
    @Schema(description = "Cidade do cliente", requiredMode = Schema.RequiredMode.REQUIRED)
    private String cidade;

    @NotNull
    @Size(min = 1, max = 50)
    @Schema(description = "Estado do cliente", requiredMode = Schema.RequiredMode.REQUIRED)
    private String estado;
}
