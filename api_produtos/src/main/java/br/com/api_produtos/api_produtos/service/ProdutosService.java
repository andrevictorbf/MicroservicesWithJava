package br.com.api_produtos.api_produtos.service;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import br.com.api_produtos.api_produtos.model.Produtos;
import br.com.api_produtos.api_produtos.model.dto.ProdutosDto;
import br.com.api_produtos.api_produtos.repository.ProdutosRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ProdutosService {

    private final ProdutosRepository produtosRepository;

    //metodos getall e getbyid 
    public Page<ProdutosDto> findAll(Pageable pagination) {
        //busca paginada pelos produtos
        return produtosRepository.findAll(pagination).map(ProdutosDto::new);
    }

    public ProdutosDto findById(Long id) {
        return new ProdutosDto(produtosRepository.getReferenceById(id));
    }

    //metodos post - novo produto
    @Transactional
    public ProdutosDto save(ProdutosDto produtosDto) {
        Produtos produtos = Produtos.fromDto(produtosDto);
        return new ProdutosDto(produtosRepository.save(produtos));
    }

    @Transactional
    public String delete(Long id) {
        //retorna uma mensagem amigavel de delete para o user
        if (produtosRepository.existsById(id)) {
            produtosRepository.deleteById(id);
            return "Produto deletado com sucesso!";
        } else {
            return "Produto não encontrado!";
        }
    }

    //metodo put - atualiza produto
    @Transactional
    public ProdutosDto update(Long id, ProdutosDto produtosDto) {
        Produtos produtos = Produtos.fromDto(produtosDto);
        produtos.setId(id);
        return new ProdutosDto(produtosRepository.save(produtos));
    }

    //atualiza valor unitario do produto
    @Transactional
    public ProdutosDto updateValorUnitario(Long id, Double valorUnitario) {
        Produtos produtos = produtosRepository.getReferenceById(id);
        produtos.setValorUnitario(valorUnitario);
        return new ProdutosDto(produtos);
    }

}
