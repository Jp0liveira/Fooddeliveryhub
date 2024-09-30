package br.com.fooddeliveryhub.fooddeliveryhub.controller.cliente;

import br.com.fooddeliveryhub.fooddeliveryhub.dto.usuario.UsuarioDto;
import br.com.fooddeliveryhub.fooddeliveryhub.model.Usuario;
import br.com.fooddeliveryhub.fooddeliveryhub.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService){
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<Usuario> cadastrarCliente(@RequestBody UsuarioDto cliente) {
        Usuario clienteSalvo = clienteService.salvar(cliente);
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
