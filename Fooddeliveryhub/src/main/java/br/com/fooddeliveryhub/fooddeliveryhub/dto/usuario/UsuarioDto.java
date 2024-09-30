package br.com.fooddeliveryhub.fooddeliveryhub.dto.usuario;

import br.com.fooddeliveryhub.fooddeliveryhub.model.Grupo;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class UsuarioDto {
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private List<Grupo> grupos;
    private LocalDateTime dataCadastro;

}