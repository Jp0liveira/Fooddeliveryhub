package br.com.fooddeliveryhub.fooddeliveryhub.controller.pedido;


import br.com.fooddeliveryhub.fooddeliveryhub.common.PedidoSwagger;
import br.com.fooddeliveryhub.fooddeliveryhub.dto.pedido.PedidoDto;
import br.com.fooddeliveryhub.fooddeliveryhub.model.Usuario;
import br.com.fooddeliveryhub.fooddeliveryhub.service.pedido.PedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.AccessDeniedException;

@RestController
@RequestMapping("/pedido")
public class PedidoController implements PedidoSwagger {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @Override
    @PostMapping("/realizarPedido")
    public ResponseEntity<String> realizarPedido(@RequestBody PedidoDto pedidoDto) {
        try {
            Usuario usuario = pedidoService.obterUsuario(pedidoDto.getClienteId());
            pedidoService.realizarPedido(usuario, pedidoDto);
            return ResponseEntity.status(HttpStatus.CREATED).body("Pedido realizado com sucesso!");
        } catch (AccessDeniedException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao realizar o pedido.");
        }
    }

}
