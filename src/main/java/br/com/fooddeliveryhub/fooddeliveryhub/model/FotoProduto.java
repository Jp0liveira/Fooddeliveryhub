package br.com.fooddeliveryhub.fooddeliveryhub.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class FotoProduto {
    @Id
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "produto_id")
    private Produto produto;

    private String nome;
    private String descricao;
    private String contentType;
    private Long tamanho;
}

