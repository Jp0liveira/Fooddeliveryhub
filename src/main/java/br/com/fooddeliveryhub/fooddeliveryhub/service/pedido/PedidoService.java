package br.com.fooddeliveryhub.fooddeliveryhub.service.pedido;

import br.com.fooddeliveryhub.fooddeliveryhub.converter.pedido.PedidoConverter;
import br.com.fooddeliveryhub.fooddeliveryhub.dto.pedido.PedidoDto;
import br.com.fooddeliveryhub.fooddeliveryhub.enums.StatusPedido;
import br.com.fooddeliveryhub.fooddeliveryhub.model.*;
import br.com.fooddeliveryhub.fooddeliveryhub.pagamento.FormaPagamentoStrategy;
import br.com.fooddeliveryhub.fooddeliveryhub.pagamento.enums.TipoPagamento;
import br.com.fooddeliveryhub.fooddeliveryhub.repository.PedidoRepository;
import br.com.fooddeliveryhub.fooddeliveryhub.service.cliente.ClienteService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

@Service
public class PedidoService {

    private final ClienteService clienteService;
    private final PedidoRepository pedidoRepository;
    private final Map<TipoPagamento, FormaPagamentoStrategy> service;

    public PedidoService(ClienteService clienteService, PedidoRepository pedidoRepository,  List<FormaPagamentoStrategy> formaPagamentoStrategies) {
        this.clienteService = clienteService;
        this.pedidoRepository = pedidoRepository;
        service = new EnumMap<>(TipoPagamento.class);
        formaPagamentoStrategies.forEach(pagamento -> service.put(pagamento.identificarPagamento(), pagamento));
    }

    @Transactional
    public Pedido realizarPedido(Usuario usuario, PedidoDto pedidoDto) throws Exception {

        Restaurante restaurante = new Restaurante();
        restaurante.setTaxaFrete(new BigDecimal(22));

//        Restaurante restaurante = restauranteRepository.findById(pedidoDto.getRestauranteId())
//                .orElseThrow(() -> new Exception("Restaurante não encontrado"));

        BigDecimal subtotal = this.calcularSubtotal(pedidoDto.getItens());
        BigDecimal taxaFrete = restaurante.getTaxaFrete();

        Pedido pedido = PedidoConverter.converterDtoPedido(pedidoDto, usuario, restaurante, StatusPedido.CRIADO, subtotal,taxaFrete);
        service.get(pedidoDto.getTipoPagamento()).pagar(pedido.getValorTotal());
        return pedidoRepository.save(pedido);
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
