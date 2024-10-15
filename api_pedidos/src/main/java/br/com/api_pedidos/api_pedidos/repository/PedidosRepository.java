package br.com.api_pedidos.api_pedidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.api_pedidos.api_pedidos.model.Pedidos;

@Repository
public interface PedidosRepository extends JpaRepository<Pedidos, Long>{

}
