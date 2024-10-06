package br.com.fooddeliveryhub.fooddeliveryhub.cliente.strategy;

import br.com.fooddeliveryhub.fooddeliveryhub.cliente.ClienteStrategy;
import br.com.fooddeliveryhub.fooddeliveryhub.cliente.enums.TipoCliente;
import br.com.fooddeliveryhub.fooddeliveryhub.dto.permissao.PermissaoDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteAdmin implements ClienteStrategy {

    @Override
    public TipoCliente identificarCliente() {
        return TipoCliente.ADMIN;
    }

    @Override
    public List<PermissaoDto> permissoesCliente() {
        return List.of(
                new PermissaoDto("GERENCIAR_USUARIOS", "Permite gerenciar usuários"),
                new PermissaoDto("GERENCIAR_PLATAFORMA", "Permite gerenciar a plataforma"),
                new PermissaoDto("GERENCIAR_PROMOCOES", "Permite gerenciar promoções"),
                new PermissaoDto("ACESSO_RELATORIOS_GLOBAIS", "Permite acessar relatórios globais")
        );
    }
}
