package br.com.fooddeliveryhub.fooddeliveryhub.cliente.strategy;

import br.com.fooddeliveryhub.fooddeliveryhub.cliente.ClienteStrategy;
import br.com.fooddeliveryhub.fooddeliveryhub.cliente.enums.TipoCliente;
import br.com.fooddeliveryhub.fooddeliveryhub.dto.permissao.PermissaoDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteCorporate implements ClienteStrategy {

    @Override
    public TipoCliente identificarCliente() {
        return TipoCliente.CORPORATE;
    }

    @Override
    public List<PermissaoDto> permissoesCliente() {
        return List.of(
                new PermissaoDto("FAZER_PEDIDO", "Permite fazer pedidos"),
                new PermissaoDto("CONSULTAR_HISTORICO", "Permite consultar histórico de pedidos"),
                new PermissaoDto("GERENCIAR_ENDERECOS", "Permite gerenciar múltiplos endereços de entrega"),
                new PermissaoDto("ACESSO_RELATORIOS", "Permite acessar relatórios de consumo")
        );
    }
}
