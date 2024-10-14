package br.com.api_produtos.api_produtos.model.dto;

import br.com.api_produtos.api_produtos.enums.ProdutosTipo;
import br.com.api_produtos.api_produtos.model.Produtos;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record ProdutosDto(
        Long id,
        @NotBlank
        String nome,
        @NotBlank
        @Min(1)
        @Max(100)
        String fornecedor,
        @NotBlank
        Integer barCode,
        @NotBlank
        Boolean disponivel,
        ProdutosTipo produtosTipo) {

    public ProdutosDto(Produtos produtos) {
        this(produtos.getId(), produtos.getNome(), produtos.getFornecedor(), produtos.getBarCode(),
                produtos.getDisponivel(), produtos.getProdutosTipo()
        );
    }

}
