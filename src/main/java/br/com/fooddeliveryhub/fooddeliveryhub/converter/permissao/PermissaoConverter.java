package br.com.fooddeliveryhub.fooddeliveryhub.converter.permissao;

import br.com.fooddeliveryhub.fooddeliveryhub.dto.permissao.PermissaoDto;
import br.com.fooddeliveryhub.fooddeliveryhub.model.Permissao;

public class PermissaoConverter {

    private  PermissaoConverter(){}

    public static Permissao converterDtoPermissao(PermissaoDto permissaoDto){
        Permissao permissao = new Permissao();
        permissao.setNome(permissaoDto.nome());
        permissao.setDescricao(permissaoDto.descricao());
        return permissao;
    }
}
