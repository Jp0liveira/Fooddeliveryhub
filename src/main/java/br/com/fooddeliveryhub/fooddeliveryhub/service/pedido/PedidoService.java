package br.com.fooddeliveryhub.fooddeliveryhub.service.pedido;

import br.com.fooddeliveryhub.fooddeliveryhub.converter.pedido.PedidoConverter;
import br.com.fooddeliveryhub.fooddeliveryhub.dto.pedido.PedidoDto;
import br.com.fooddeliveryhub.fooddeliveryhub.enums.StatusPedido;
import br.com.fooddeliveryhub.fooddeliveryhub.model.ItemPedido;
import br.com.fooddeliveryhub.fooddeliveryhub.model.Pedido;
import br.com.fooddeliveryhub.fooddeliveryhub.model.Restaurante;
import br.com.fooddeliveryhub.fooddeliveryhub.model.Usuario;
import br.com.fooddeliveryhub.fooddeliveryhub.repository.PedidoRepository;
import br.com.fooddeliveryhub.fooddeliveryhub.service.cliente.ClienteService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class PedidoService {

    private final ClienteService clienteService;
    private final PedidoRepository pedidoRepository;

    public PedidoService(ClienteService clienteService, PedidoRepository pedidoRepository) {
        this.clienteService = clienteService;
        this.pedidoRepository = pedidoRepository;
    }

    public Pedido realizarPedido(Usuario usuario, PedidoDto pedidoDto) throws Exception {

        Restaurante restaurante = new Restaurante();
//        Restaurante restaurante = restauranteRepository.findById(pedidoDto.getRestauranteId())
//                .orElseThrow(() -> new Exception("Restaurante não encontrado"));

        BigDecimal subtotal = this.calcularSubtotal(pedidoDto.getItens());
        BigDecimal taxaFrete = restaurante.getTaxaFrete();

        return pedidoRepository.save(PedidoConverter.converterDtoPedido(pedidoDto, usuario, restaurante, StatusPedido.CRIADO, subtotal,taxaFrete));
    }

    public BigDecimal calcularSubtotal(List<ItemPedido> itens) {
        return itens.stream()
                .map(item -> item.getPrecoUnitario().multiply(BigDecimal.valueOf(item.getQuantidade())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public Usuario obterUsuario(Long idUsuario){
        return clienteService.buscarPorId(idUsuario);
    }

}
