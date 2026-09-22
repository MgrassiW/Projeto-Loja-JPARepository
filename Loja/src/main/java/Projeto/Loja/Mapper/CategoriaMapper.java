package Projeto.Loja.Mapper;

import Projeto.Loja.DTO.CategoriaRequest;
import Projeto.Loja.DTO.CategoriaResponse;
import Projeto.Loja.Entity.Categoria;
import org.springframework.stereotype.Component;

@Component
public class CategoriaMapper {

    public Categoria toEntity(CategoriaRequest request) {

        return Categoria.builder()
                .nome(request.nome())
                .build();
    }

    public CategoriaResponse toResponse(Categoria categoria) {

        return new CategoriaResponse(
                categoria.getId(),
                categoria.getNome()
        );
    }

    public void updateEntity(CategoriaRequest request , Categoria categoria) {

        categoria.setNome(request.nome());
    }
}
