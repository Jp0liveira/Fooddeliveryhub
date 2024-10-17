package br.com.fooddeliveryhub.fooddeliveryhub.common;

import br.com.fooddeliveryhub.fooddeliveryhub.dto.pedido.PedidoDto;
import org.springframework.http.ResponseEntity;

public interface PedidoSwagger {
    ResponseEntity<String> realizarPedido(PedidoDto pedidoDto);
}
