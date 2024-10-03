package br.com.fooddeliveryhub.fooddeliveryhub.converter.usuario;

import br.com.fooddeliveryhub.fooddeliveryhub.dto.usuario.UsuarioDto;
import br.com.fooddeliveryhub.fooddeliveryhub.enums.TipoCliente;
import br.com.fooddeliveryhub.fooddeliveryhub.model.Grupo;
import br.com.fooddeliveryhub.fooddeliveryhub.model.Permissao;
import br.com.fooddeliveryhub.fooddeliveryhub.model.Usuario;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UsuarioConverter {

    private UsuarioConverter(){}

    public static Usuario converterDtoUsuario(UsuarioDto usuarioDto, TipoCliente tipoCliente){
        Usuario usuario = new Usuario();
        Grupo grupo = new Grupo();
        List<Permissao> permissaos = new ArrayList<>();
        Permissao permissao = new Permissao();
        permissao.se
        permissaos.add(permissao);

        grupo.setNome(tipoCliente.getDescricao());
        grupo.setPermissoes(permissaos);

        usuario.setNome(usuarioDto.getNome());
        usuario.setEmail(usuarioDto.getEmail());
        usuario.setSenha("********");
        usuario.setGrupos(grupo);
        usuario.setDataCadastro(LocalDateTime.now());
        return usuario;
    }

}
