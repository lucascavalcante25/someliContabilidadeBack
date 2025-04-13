package com.someli.someli.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.someli.someli.dto.UsuarioDTO;
import com.someli.someli.model.Usuario;
import com.someli.someli.service.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping
	public ResponseEntity<List<UsuarioDTO>> listarTodos() {
	    List<UsuarioDTO> usuarios = usuarioService.listarTodos();
	    return ResponseEntity.ok(usuarios);
	}


	@PostMapping
	public ResponseEntity<Usuario> salvar(@RequestBody UsuarioDTO dto) {
		Usuario usuarioSalvo = usuarioService.salvar(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioSalvo);
	}
}
