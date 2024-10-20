package br.com.fooddeliveryhub.fooddeliveryhub.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Cidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "estado_id", nullable = false)
    private Estado estado;

    // Novos atributos para latitude e longitude 
    @Column(nullable = false)
    private Double latitude;

    @Column(nullable = false)
    private Double longitude;
}

