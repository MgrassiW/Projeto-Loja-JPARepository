package Projeto.Loja.Entity;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "produtos")
@Builder
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome" , nullable = false , length = 150)
    private String nome;

    @Column(name = "preco" , nullable = false , precision = 10 , scale = 2)
    private BigDecimal preco;

    @Column (name = "estoque" , nullable = false )
    private int estoque;

    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;
}
