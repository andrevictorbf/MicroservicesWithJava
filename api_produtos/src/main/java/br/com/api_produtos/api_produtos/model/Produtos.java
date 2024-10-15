package br.com.api_produtos.api_produtos.model;

import java.time.LocalDateTime;

import br.com.api_produtos.api_produtos.enums.ProdutosTipo;
import br.com.api_produtos.api_produtos.model.dto.ProdutosDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "produtos")
public class Produtos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100)
    private String nome;
    //Implementar Valor
    private Double valorUnitario;
    @Column(nullable = false, length = 60)
    private String fornecedor;
    @Column(nullable = false)
    private String imagem;
    @Column(nullable = false, length = 12)
    private Integer barCode;
    @Column(nullable = false)
    private Boolean disponivel;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ProdutosTipo produtosTipo;
    //dados de auditoria - manut
    @Column(nullable = false)
    private LocalDateTime dataCadastro;
    @Column(nullable = false)
    private String usuarioCadastro;

    public static Produtos fromDto(ProdutosDto produtosDto) {
        return new Produtos(
            null, 
            produtosDto.nome(), 
            produtosDto.fornecedor(), 
            null,
            produtosDto.barCode(), 
            produtosDto.disponivel(), 
            produtosDto.produtosTipo(), 
            LocalDateTime.now(), // Definindo data de cadastro atual
            "sistema" // Usuário de cadastro pode ser alterado conforme o contexto da aplicação
        );
    }
}
