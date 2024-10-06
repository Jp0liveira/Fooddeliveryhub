package br.com.fooddeliveryhub.fooddeliveryhub.service.cliente;

import br.com.fooddeliveryhub.fooddeliveryhub.cliente.enums.TipoCliente;
import br.com.fooddeliveryhub.fooddeliveryhub.converter.permissao.PermissaoConverter;
import br.com.fooddeliveryhub.fooddeliveryhub.converter.usuario.UsuarioConverter;
import br.com.fooddeliveryhub.fooddeliveryhub.dto.permissao.PermissaoDto;
import br.com.fooddeliveryhub.fooddeliveryhub.dto.usuario.UsuarioDto;
import br.com.fooddeliveryhub.fooddeliveryhub.model.Permissao;
import br.com.fooddeliveryhub.fooddeliveryhub.model.Usuario;
import br.com.fooddeliveryhub.fooddeliveryhub.repository.UsuarioRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private final UsuarioRepository usuarioRepository;

    public ClienteService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Transactional
    public Usuario salvar(UsuarioDto usuario, TipoCliente tipoCliente, List<PermissaoDto> permissaoDto) {
        Optional<Usuario> usuarioExistente = usuarioRepository.findByEmail(usuario.getEmail());
        if (usuarioExistente.isPresent()) {
            throw new EntityExistsException("Já existe um cliente com este email.");
        }
        List<Permissao> permissaoList = permissaoDto.stream().map(PermissaoConverter::converterDtoPermissao).toList();

        return usuarioRepository.save(UsuarioConverter.converterDtoUsuario(usuario, tipoCliente));
    }

    public TipoCliente identificarCliente(Integer idUsuario) {
        return switch (idUsuario) {
            case 2 -> TipoCliente.PREMIUM;
            case 3 -> TipoCliente.CORPORATE;
            case 4 -> TipoCliente.PARTNER;
            case 5 -> TipoCliente.ADMIN;
            default -> TipoCliente.BASIC;
        };
    }

    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));
    }

    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }

    @Transactional
    public void excluir(Long id) {
        Usuario cliente = buscarPorId(id);
        usuarioRepository.delete(cliente);
    }
}

