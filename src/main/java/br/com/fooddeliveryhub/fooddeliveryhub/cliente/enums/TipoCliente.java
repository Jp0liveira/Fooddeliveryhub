package br.com.fooddeliveryhub.fooddeliveryhub.cliente.enums;

import lombok.Getter;

@Getter
public enum TipoCliente {
    BASIC(1, "Cliente Básico"),
    PREMIUM(2, "Cliente Premium"),
    CORPORATE(3, "Cliente Corporativo"),
    PARTNER(4,"Parceiro"),
    ADMIN(5,"Administrador");

    private final Integer id;
    private final String descricao;

    TipoCliente(Integer id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }
}
