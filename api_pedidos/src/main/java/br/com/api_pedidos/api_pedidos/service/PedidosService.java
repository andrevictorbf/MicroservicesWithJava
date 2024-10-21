package br.com.api_pedidos.api_pedidos.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.api_pedidos.api_pedidos.model.Pedidos;
import br.com.api_pedidos.api_pedidos.model.dto.PedidosDto;
import br.com.api_pedidos.api_pedidos.repository.PedidosRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PedidosService {

    private final PedidosRepository pedidosRepository;

    //metodos Get: byId e all
    public PedidosDto findById(Long id) {
        Pedidos pedidos = pedidosRepository.getReferenceById(id);
        return new PedidosDto(pedidos);
    }

    public Page<PedidosDto> findAll(Pageable pagination) {
        //busca paginada pelos produtos
        return pedidosRepository.findAll(pagination).map(PedidosDto::new);
    }

    //metodo post - salvando apenas um produto por vez
    public PedidosDto save(PedidosDto pedidosDto) {
        Pedidos pedidos = Pedidos.fromDto(pedidosDto);
        return new PedidosDto(pedidosRepository.save(pedidos));
    }

    //metodo update
    public PedidosDto update(Long id, PedidosDto pedidosDto) {
        Pedidos pedidos = Pedidos.fromDto(pedidosDto);
        pedidos.setId(id);
        return new PedidosDto(pedidosRepository.save(pedidos));

    }
    
    //metodo delete
    @Transactional
    public String delete(Long id) {
        //retorna uma mensagem amigavel de delete para o user
        if (pedidosRepository.existsById(id)) {
            pedidosRepository.deleteById(id);
            return "Pedido deletado com sucesso!";
        } else {
            return "Pedido não encontrado!";
        }
    }

}
