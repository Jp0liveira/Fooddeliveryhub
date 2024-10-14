package br.com.fooddeliveryhub.fooddeliveryhub.pagamento;

import br.com.fooddeliveryhub.fooddeliveryhub.pagamento.enums.TipoPagamento;

import java.math.BigDecimal;

public interface FormaPagamentoStrategy {
    TipoPagamento identificarPagamento();
    void pagar(BigDecimal valor);
}
