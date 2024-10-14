package br.com.fooddeliveryhub.fooddeliveryhub.converter.pedido;

import br.com.fooddeliveryhub.fooddeliveryhub.dto.pedido.PedidoDto;
import br.com.fooddeliveryhub.fooddeliveryhub.enums.StatusPedido;
import br.com.fooddeliveryhub.fooddeliveryhub.model.FormaPagamento;
import br.com.fooddeliveryhub.fooddeliveryhub.model.Pedido;
import br.com.fooddeliveryhub.fooddeliveryhub.model.Restaurante;
import br.com.fooddeliveryhub.fooddeliveryhub.model.Usuario;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PedidoConverter {

    private PedidoConverter() {
    }

    public static Pedido converterDtoPedido(PedidoDto pedidoDto, Usuario usuario, Restaurante restaurante,
                                            StatusPedido statusPedido, BigDecimal subtotal, BigDecimal taxaFrete) {
        Pedido pedido = new Pedido();
        FormaPagamento formaPagamento = new FormaPagamento();

        formaPagamento.setId(Long.valueOf(pedidoDto.getTipoPagamento().getId()));
        formaPagamento.setDescricao(pedidoDto.getTipoPagamento().getDescricao());

        pedido.setCliente(usuario);
        pedido.setRestaurante(restaurante);
        pedido.setItens(pedidoDto.getItens());
        pedido.setFormaPagamento(formaPagamento);
        pedido.setEnderecoEntrega(pedidoDto.getEnderecoEntrega());
        pedido.setSubtotal(subtotal);
        pedido.setTaxaFrete(taxaFrete);
        pedido.setValorTotal(pedido.getSubtotal().add(pedido.getTaxaFrete()));
        pedido.setStatus(statusPedido);
        pedido.setDataCriacao(LocalDateTime.now());
        return pedido;
    }
}
