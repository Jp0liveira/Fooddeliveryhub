package br.com.fooddeliveryhub.fooddeliveryhub.controller.cliente;

import br.com.fooddeliveryhub.fooddeliveryhub.cliente.ClienteStrategy;
import br.com.fooddeliveryhub.fooddeliveryhub.cliente.enums.TipoCliente;
import br.com.fooddeliveryhub.fooddeliveryhub.common.FoodDeliveryHubSwagger;
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
public class ClienteController implements FoodDeliveryHubSwagger<Usuario, Long> {

    private final ClienteService clienteService;
    private final Map<TipoCliente, ClienteStrategy> service;

    public ClienteController(ClienteService clienteService, List<ClienteStrategy> clienteStrategies){
        this.clienteService = clienteService;
        service = new EnumMap<>(TipoCliente.class);
        clienteStrategies.forEach(cliente -> service.put(cliente.identificarCliente(), cliente));
    }

    @Override
    @PostMapping("/cadastrarCliente")
    public ResponseEntity<Usuario> salvar(@RequestBody UsuarioDto usuarioDto) {
        TipoCliente tipoCliente = clienteService.identificarCliente(usuarioDto.getTipoCliente());
        List<PermissaoDto> permissaoDto = service.get(tipoCliente).permissoesCliente();
        Usuario clienteSalvo = clienteService.salvar(usuarioDto, tipoCliente, permissaoDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteSalvo);
    }

    @Override
    @GetMapping("/buscarClientePorId/{id}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable Long id) {
        Usuario cliente = clienteService.buscarPorId(id);
        return ResponseEntity.ok(cliente);
    }

    @Override
    @GetMapping("/listarClientes")
    public ResponseEntity<List<Usuario>> listar() {
        List<Usuario> clientes = clienteService.listar();
        return ResponseEntity.ok(clientes);
    }

    @Override
    @DeleteMapping("/deletarCliente/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        clienteService.excluir(id);
        return ResponseEntity.noContent().build();
    }

}
