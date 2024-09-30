package br.com.fooddeliveryhub.fooddeliveryhub.enums;

import lombok.Getter;

@Getter
public enum StatusPedido {
    CRIADO(1, "Pedido Realizado"),
    CONFIRMADO(2, "Pedido Confirmado"),
    ENTREGUE(3, "Pedido Entregue"),
    CANCELADO(4, "Pedido Cancelado");

    private final Integer id;
    private final String descricao;

    StatusPedido(Integer id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }
}
