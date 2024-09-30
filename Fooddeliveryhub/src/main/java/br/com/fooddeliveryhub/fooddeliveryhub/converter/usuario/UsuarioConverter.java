package br.com.fooddeliveryhub.fooddeliveryhub.converter.usuario;

import br.com.fooddeliveryhub.fooddeliveryhub.dto.usuario.UsuarioDto;
import br.com.fooddeliveryhub.fooddeliveryhub.model.Usuario;

import java.time.LocalDateTime;

public class UsuarioConverter {

    private UsuarioConverter(){}

    public static Usuario converterDtoUsuario(UsuarioDto usuarioDto){
        Usuario usuario = new Usuario();
        usuario.setId(usuarioDto.getId());
        usuario.setNome(usuarioDto.getNome());
        usuario.setEmail(usuarioDto.getEmail());
        usuario.setSenha("********");
        usuario.setGrupos(usuarioDto.getGrupos());
        usuario.setDataCadastro(LocalDateTime.now());
        return usuario;
    }

}
