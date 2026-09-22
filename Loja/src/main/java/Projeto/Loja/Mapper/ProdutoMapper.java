package Projeto.Loja.Mapper;

import Projeto.Loja.DTO.CategoriaResponse;
import Projeto.Loja.DTO.ProdutoRequest;
import Projeto.Loja.DTO.ProdutoResponse;
import Projeto.Loja.Entity.Categoria;
import Projeto.Loja.Entity.Produto;
import org.springframework.stereotype.Component;

@Component
public class ProdutoMapper {

    public Produto toEntity(ProdutoRequest request , Categoria categoria) {

        return Produto.builder()
                .nome(request.nome())
                .preco(request.preco())
                .estoque(request.estoque())
                .categoria(categoria)
                .build();
    }

    public ProdutoResponse toResponse(Produto produto) {

        CategoriaResponse categoria = new CategoriaResponse(
                produto.getCategoria().getId(),
                produto.getCategoria().getNome()
        );

        return new ProdutoResponse(
                produto.getId(),
                produto.getNome(),
                produto.getPreco(),
                produto.getEstoque(),
                categoria
        );
    }

    public void updateEntity(ProdutoRequest request, Produto produto, Categoria categoria) {

        produto.setNome(request.nome());
        produto.setPreco(request.preco());
        produto.setEstoque(request.estoque());
        produto.setCategoria(categoria);
    }
}
