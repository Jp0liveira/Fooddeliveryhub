package br.com.fooddeliveryhub.fooddeliveryhub.dto.pedido;

import br.com.fooddeliveryhub.fooddeliveryhub.model.Endereco;
import br.com.fooddeliveryhub.fooddeliveryhub.model.ItemPedido;
import br.com.fooddeliveryhub.fooddeliveryhub.pagamento.enums.TipoPagamento;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PedidoDto {
    private Long clienteId;
    private Long restauranteId;
    private List<ItemPedido> itens;
    private TipoPagamento tipoPagamento;
    private Endereco enderecoEntrega;
}
