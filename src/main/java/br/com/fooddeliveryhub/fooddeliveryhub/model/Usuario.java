package br.com.fooddeliveryhub.fooddeliveryhub.model;

import br.com.fooddeliveryhub.fooddeliveryhub.common.Pessoa;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Usuario extends Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String senha;

    @ManyToOne
    @JoinTable(name = "usuario_grupo",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "grupo_id"))
    private Grupo grupos;

    @Column(nullable = false)
    private LocalDateTime dataCadastro;
}
