package br.com.fooddeliveryhub.fooddeliveryhub.pagamento.strategy;

import br.com.fooddeliveryhub.fooddeliveryhub.pagamento.FormaPagamentoStrategy;
import br.com.fooddeliveryhub.fooddeliveryhub.pagamento.enums.TipoPagamento;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class BoletoBancario implements FormaPagamentoStrategy {

    @Override
    public TipoPagamento identificarPagamento() {
        return TipoPagamento.BOLETO;
    }
    @Override
    public void pagar(BigDecimal valor) {
        System.out.println("Pagamento de " + valor + " realizado com Boleto Bancário.");
    }
}