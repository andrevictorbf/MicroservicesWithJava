package br.com.api_pedidos.api_pedidos.model;

import br.com.api_pedidos.api_pedidos.model.dto.PedidosDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pedidos")
public class Pedidos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Double valorTotal;
    @Column(nullable = false)
    private Long idProduto;
    @Column(nullable = false)
    private Integer quantItem;

    public static Pedidos fromDto(PedidosDto pedidosDto) {
        return new Pedidos(null, pedidosDto.valorTotal(), pedidosDto.idProduto(), pedidosDto.quantItem());
    }
}
