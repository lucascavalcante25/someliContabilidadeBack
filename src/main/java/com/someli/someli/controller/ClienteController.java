package com.someli.someli.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.someli.someli.dto.ClienteDTO;
import com.someli.someli.model.Cliente;
import com.someli.someli.service.ClienteService;

@RestController
@RequestMapping("/someli/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@GetMapping("/buscarPorId/{id}")
	public ResponseEntity<?> obterClientePorId(@PathVariable Long id) {
		ClienteDTO clienteDTO = clienteService.obterDadosClientePorId(id);

		if (clienteDTO != null) {
			return ResponseEntity.ok(clienteDTO);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado.");
		}
	}

	@GetMapping("/listarClientes")
	public ResponseEntity<List<ClienteDTO>> listarClientes() {

		List<ClienteDTO> listaDeClientes = clienteService.listarTodos();
		return ResponseEntity.ok(listaDeClientes);
	}

	@PostMapping("/salvarCliente")
	public ResponseEntity<?> salvarCliente(@RequestBody ClienteDTO clienteDTO) {
		Cliente cliente = clienteService.salvarCliente(clienteDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
	}

	@PutMapping("/atualizarCliente/{id}")
	public ResponseEntity<Cliente> atualizarCliente(@PathVariable Long id, @RequestBody ClienteDTO clienteDTO) {
	    Optional<Cliente> clienteAtualizado = clienteService.atualizarCliente(id, clienteDTO);
	    return clienteAtualizado.map(ResponseEntity::ok)
	            .orElseGet(() -> ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/excluirCliente/{id}")
	public ResponseEntity<Void> excluirCliente(@PathVariable Long id) {
	    clienteService.excluirCliente(id);
	    return ResponseEntity.noContent().build();
	}


}
