package br.com.fooddeliveryhub.fooddeliveryhub.converter.usuario;

import br.com.fooddeliveryhub.fooddeliveryhub.cliente.enums.TipoCliente;
import br.com.fooddeliveryhub.fooddeliveryhub.dto.usuario.UsuarioDto;
import br.com.fooddeliveryhub.fooddeliveryhub.model.Grupo;
import br.com.fooddeliveryhub.fooddeliveryhub.model.Usuario;

import java.time.LocalDateTime;

public class UsuarioConverter {

    private UsuarioConverter(){}

    public static Usuario converterDtoUsuario(UsuarioDto usuarioDto, TipoCliente tipoCliente){
        Usuario usuario = new Usuario();
        Grupo grupo = new Grupo();
        grupo.setId(Long.valueOf(tipoCliente.getId()));
        usuario.setNome(usuarioDto.getNome());
        usuario.setEmail(usuarioDto.getEmail());
        usuario.setSenha("********");
        usuario.setGrupos(grupo);
        usuario.setDataCadastro(LocalDateTime.now());
        return usuario;
    }

}
