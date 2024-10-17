package br.com.fooddeliveryhub.fooddeliveryhub.controller.cliente;

import br.com.fooddeliveryhub.fooddeliveryhub.cliente.enums.TipoCliente;
import br.com.fooddeliveryhub.fooddeliveryhub.common.ClienteSwagger;
import br.com.fooddeliveryhub.fooddeliveryhub.dto.usuario.UsuarioDto;
import br.com.fooddeliveryhub.fooddeliveryhub.model.Usuario;
import br.com.fooddeliveryhub.fooddeliveryhub.service.cliente.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController implements ClienteSwagger{

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService){
        this.clienteService = clienteService;
    }

    @Override
    @PostMapping("/cadastrarCliente")
    public ResponseEntity<Usuario> salvar(@RequestBody UsuarioDto usuarioDto) {
        TipoCliente tipoCliente = clienteService.identificarCliente(usuarioDto.getTipoCliente());
        Usuario clienteSalvo = clienteService.salvar(usuarioDto, tipoCliente);
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
