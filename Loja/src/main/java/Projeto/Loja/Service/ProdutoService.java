package Projeto.Loja.Service;

import Projeto.Loja.DTO.ProdutoRequest;
import Projeto.Loja.DTO.ProdutoResponse;
import Projeto.Loja.Entity.Categoria;
import Projeto.Loja.Entity.Produto;
import Projeto.Loja.Mapper.ProdutoMapper;
import Projeto.Loja.Repository.CategoriaRepository;
import Projeto.Loja.Repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProdutoService {

    private final CategoriaRepository categoriaRepository;
    private final ProdutoRepository produtoRepository;
    private final ProdutoMapper produtoMapper;

    public ProdutoResponse save(ProdutoRequest request) {

        Categoria categoria = categoriaRepository.findById(request.categoriaId())
                .orElseThrow();

        Produto produto = produtoMapper.toEntity(
                request,
                categoria
        );

        Produto produtoSalvo = produtoRepository.save(produto);

        return produtoMapper.toResponse(produtoSalvo);
    }

    public List<ProdutoResponse> findAll() {

        return produtoRepository.findAll()
                .stream()
                .map(produtoMapper::toResponse)
                .toList();
    }

    public ProdutoResponse findById(Long id) {

        Produto produto = produtoRepository.findById(id)
                .orElseThrow();

        return produtoMapper.toResponse(produto);
    }

    public ProdutoResponse update(Long id, ProdutoRequest request) {

        Produto produto = produtoRepository.findById(id)
                .orElseThrow();

        Categoria categoria = categoriaRepository.findById(request.categoriaId())
                .orElseThrow();

        produtoMapper.updateEntity(
                request,
                produto,
                categoria
        );

        Produto produtoSalvo = produtoRepository.save(produto);

        return produtoMapper.toResponse(produtoSalvo);
    }

    public void delete(Long id) {

        produtoRepository.deleteById(id);
    }
}
