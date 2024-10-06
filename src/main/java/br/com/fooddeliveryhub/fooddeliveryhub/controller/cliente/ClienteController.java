package br.com.fooddeliveryhub.fooddeliveryhub.controller.cliente;

import br.com.fooddeliveryhub.fooddeliveryhub.cliente.ClienteStrategy;
import br.com.fooddeliveryhub.fooddeliveryhub.cliente.enums.TipoCliente;
import br.com.fooddeliveryhub.fooddeliveryhub.dto.permissao.PermissaoDto;
import br.com.fooddeliveryhub.fooddeliveryhub.dto.usuario.UsuarioDto;
import br.com.fooddeliveryhub.fooddeliveryhub.model.Usuario;
import br.com.fooddeliveryhub.fooddeliveryhub.service.cliente.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;
    private final Map<TipoCliente, ClienteStrategy> service;

    public ClienteController(ClienteService clienteService, List<ClienteStrategy> clienteStrategies){
        this.clienteService = clienteService;
        service = new EnumMap<>(TipoCliente.class);
        clienteStrategies.forEach(cliente -> service.put(cliente.identificarCliente(), cliente));
    }

    @PostMapping
    public ResponseEntity<Usuario> cadastrarCliente(@RequestBody UsuarioDto usuarioDto) {
        TipoCliente tipoCliente = clienteService.identificarCliente(usuarioDto.getTipoCliente());
        List<PermissaoDto> permissaoDto = service.get(tipoCliente).permissoesCliente();
        Usuario clienteSalvo = clienteService.salvar(usuarioDto, tipoCliente, permissaoDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteSalvo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarClientePorId(@PathVariable Long id) {
        Usuario cliente = clienteService.buscarPorId(id);
        return ResponseEntity.ok(cliente);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listarClientes() {
        List<Usuario> clientes = clienteService.listar();
        return ResponseEntity.ok(clientes);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable Long id) {
        clienteService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
