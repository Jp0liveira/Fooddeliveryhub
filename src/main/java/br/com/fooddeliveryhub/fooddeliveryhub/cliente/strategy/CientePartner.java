package br.com.fooddeliveryhub.fooddeliveryhub.cliente.strategy;

import br.com.fooddeliveryhub.fooddeliveryhub.cliente.ClienteStrategy;
import br.com.fooddeliveryhub.fooddeliveryhub.cliente.enums.TipoCliente;
import br.com.fooddeliveryhub.fooddeliveryhub.dto.permissao.PermissaoDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CientePartner implements ClienteStrategy {

    @Override
    public TipoCliente identificarCliente() {
        return TipoCliente.PARTNER;
    }

    @Override
    public List<PermissaoDto> permissoesCliente() {
        return List.of(
                new PermissaoDto("GERENCIAR_CARDAPIO", "Permite gerenciar o cardápio"),
                new PermissaoDto("GERENCIAR_PEDIDOS", "Permite gerenciar pedidos"),
                new PermissaoDto("ATUALIZAR_STATUS_PEDIDOS", "Permite atualizar o status dos pedidos")
        );
    }
}
