package br.com.fooddeliveryhub.fooddeliveryhub.cliente;

import br.com.fooddeliveryhub.fooddeliveryhub.cliente.enums.TipoCliente;
import br.com.fooddeliveryhub.fooddeliveryhub.dto.permissao.PermissaoDto;

import java.util.List;

public interface ClienteStrategy {
    TipoCliente identificarCliente();
    List<PermissaoDto> permissoesCliente();

}
