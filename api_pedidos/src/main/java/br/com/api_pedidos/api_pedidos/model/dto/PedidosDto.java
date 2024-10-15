package br.com.api_pedidos.api_pedidos.model.dto;

import br.com.api_pedidos.api_pedidos.model.Pedidos;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PedidosDto(
        Long id,
        @NotBlank
        Double valorTotal,
        @NotNull
        Long idProduto,
        @NotBlank
        Integer quantItem) {

    public PedidosDto(Pedidos pedidos) {
        this(pedidos.getId(), pedidos.getValorTotal(), pedidos.getIdProduto(), pedidos.getQuantItem());
    }

}
