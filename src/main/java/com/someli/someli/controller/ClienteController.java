package com.someli.someli.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.someli.someli.dto.ClienteDTO;
import com.someli.someli.model.Cliente;
import com.someli.someli.service.ClienteService;

@RestController
@RequestMapping("/someli/cliente")
@CrossOrigin(origins = "https://localhost:4200", allowedHeaders = "*", methods = { RequestMethod.GET,
		RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@GetMapping("/{id}")
	public ResponseEntity<?>  obterClientePorId(@PathVariable Long id) {
		
		ClienteDTO clienteDTO = clienteService.obterDadosClientePorId(id);
		return ResponseEntity.ok(clienteDTO);
	} 
	
	@GetMapping("/listarClientes")
	public ResponseEntity<List<ClienteDTO>>listarClientes() {
		
		List<ClienteDTO> listaDeClientes = clienteService.listarTodos();
		return ResponseEntity.ok(listaDeClientes);
	} 
	
	
	@PostMapping("/salvarCliente")
	public ResponseEntity<?> salvarCliente(@RequestBody ClienteDTO clienteDTO) {
	    Cliente cliente = clienteService.salvarCliente(clienteDTO);
	    return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
	}

	
	
	
	
}
