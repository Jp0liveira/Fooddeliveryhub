package br.com.fooddeliveryhub.fooddeliveryhub.pagamento.enums;

import lombok.Getter;

@Getter
public enum TipoPagamento {
    PIX(1, "Pagamento por pix"),
    CARTAO(2, "Pagamento por cartão"),
    BOLETO(3, "Pagamento por boleto");

    private final Integer id;
    private final String descricao;

    TipoPagamento(Integer id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }
}
