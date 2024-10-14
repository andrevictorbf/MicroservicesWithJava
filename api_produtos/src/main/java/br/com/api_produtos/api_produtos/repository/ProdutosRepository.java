package br.com.api_produtos.api_produtos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.api_produtos.api_produtos.model.Produtos;

@Repository
public interface  ProdutosRepository extends JpaRepository<Produtos, Long> {
}
