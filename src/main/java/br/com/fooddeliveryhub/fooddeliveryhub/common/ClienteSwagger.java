package br.com.fooddeliveryhub.fooddeliveryhub.common;

import br.com.fooddeliveryhub.fooddeliveryhub.dto.usuario.UsuarioDto;
import br.com.fooddeliveryhub.fooddeliveryhub.model.Usuario;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ClienteSwagger {
    ResponseEntity<List<Usuario>> listar();

    ResponseEntity<Usuario> buscarPorId(Long id);

    ResponseEntity<Usuario> salvar(UsuarioDto objeto);

//    ResponseEntity<T> atualizar(ID id, T objeto);

    ResponseEntity<Void> deletar(Long id);
}
